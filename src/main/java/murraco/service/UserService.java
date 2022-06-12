package murraco.service;

import lombok.RequiredArgsConstructor;
import murraco.dto.v1.LoginRes;
import murraco.exception.CustomException;
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
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return LoginRes.builder()
                    .accessToken(jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getAppUserRole()))
                    .build();
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public LoginRes signup(AppUser appUser) {
        if (!userRepository.existsByUsername(appUser.getUsername())) {
            appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
            userRepository.save(appUser);

            UserActive userActive = new UserActive(appUser.getId());
             userActiveRepository.save(userActive);

            emailService.sendSimpleMessage(
                    appUser.getEmail(),
                    userActive.getActiveCode().toString(),
                    "Your code: " + userActive.getActiveCode().toString()
            );

            return LoginRes.builder()
                    .accessToken(jwtTokenProvider.createToken(appUser.getUsername(), appUser.getAppUserRole()))
                    .userRole(appUser.getAppUserRole().getIndex())
                    .build();
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
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
}
