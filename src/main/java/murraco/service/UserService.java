package murraco.service;

import lombok.RequiredArgsConstructor;
import murraco.dto.v1.LoginRes;
import murraco.dto.v1.UserActiveDTO;
import murraco.dto.v1.UserDataDTO;
import murraco.exception.CustomException;
import murraco.mappers.UserMapper;
import murraco.model.AppUser;
import murraco.model.UserActive;
import murraco.repository.UserActiveRepository;
import murraco.repository.UserRepository;
import murraco.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    private final UserActiveRepository userActiveRepository;

    private final EmailService emailService;

    public LoginRes signIn(String username, String password) {
        try {
            AppUser appUser = userRepository.findByUsernameAndDeletedDateNull(username);
            UserActive userActive = userActiveRepository.findByUserIdAndDeletedDateNull(appUser.getId());
            if (userActive != null) {
                throw new CustomException("User isn't active yet", HttpStatus.NOT_ACCEPTABLE);
            }
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return LoginRes.builder()
                    .accessToken(jwtTokenProvider.createToken(username, appUser.getAppUserRole()))
                    .build();
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public Map<String, ?> signup(UserDataDTO userDataDTO) {
        AppUser appUser = UserMapper.fromDTO(userDataDTO);
        if (userRepository.existsByUsername(userDataDTO.getUsername())
                        || userRepository.existsByEmail(userDataDTO.getEmail())) {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        userRepository.save(appUser);

        UserActive userActive = new UserActive(appUser.getId());
        userActiveRepository.save(userActive);

        emailService.sendSimpleMessage(
                appUser.getEmail(),
                userActive.getActiveCode().toString(),
                "Your code: " + userActive.getActiveCode().toString()
        );

        Map<String, Integer> response = new HashMap<>();
        response.put("user_id", appUser.getId());
        return response;
    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public AppUser search(String username) {
        AppUser appUser = userRepository.findByUsername(username);
        if (appUser == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return appUser;
    }

    public AppUser whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getAppUserRole());
    }

    public void resetActiveCode(Integer userId) {
        UserActive userActive = userActiveRepository.findByUserIdAndDeletedDateNull(userId);
        if (userActive == null) {
            throw new CustomException("User is not found!", HttpStatus.NOT_FOUND);
        }
        userActive.generateActiveCode();
        userActiveRepository.save(userActive);
    }

    public void activeUser(UserActiveDTO userActiveDTO) {
        UserActive userActive = userActiveRepository.findByUserIdAndDeletedDateNull(userActiveDTO.getUserId());
        if (userActive == null) {
            throw new CustomException("User is not found!", HttpStatus.NOT_FOUND);
        }
        userActive.setDeletedDate(LocalDateTime.now());
        userActiveRepository.save(userActive);
    }
}
