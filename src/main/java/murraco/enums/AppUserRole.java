package murraco.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum AppUserRole implements GrantedAuthority {
    ROLE_ADMIN(1),
    ROLE_EMPLOYEE(2),
    ROLE_APPLICANT(3);

    public String getAuthority() {
        return name();
    }

    private final Integer index;

    AppUserRole(Integer index) {
        this.index = index;
    }
}
