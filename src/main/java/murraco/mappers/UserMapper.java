package murraco.mappers;

import murraco.dto.v1.UserDataDTO;
import murraco.enums.AppUserRole;
import murraco.helpers.EnumHelper;
import murraco.model.AppUser;

public class UserMapper {
    static public AppUser fromDTO(UserDataDTO userDataDTO) {
        AppUser appUser = new AppUser();
        appUser.setUsername(userDataDTO.getUsername());
        appUser.setPassword(userDataDTO.getPassword());
        appUser.setEmail(userDataDTO.getEmail());

        AppUserRole appUserRole = EnumHelper.getUserRoleFromIndex(userDataDTO.getAppUserRole());
        appUser.setAppUserRole(appUserRole);
        return appUser;
    }
}
