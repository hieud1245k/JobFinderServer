package murraco.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import murraco.enums.AppUserRole;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "app_users")
@Data // Create getters and setters
@NoArgsConstructor
public class AppUser extends BaseModel {

  @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
  @Column(unique = true, nullable = false)
  private String username;

  @Column(unique = true, nullable = false)
  private String email;

  @Size(min = 8, message = "Minimum password length: 8 characters")
  private String password;

  AppUserRole appUserRole;

  private Boolean isActive = false;
}
