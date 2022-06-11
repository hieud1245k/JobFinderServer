package murraco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "applicants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Applicant extends BaseModel {
    private String fullName;
    private String dayOfBirth;
    private String address;
    private String occupation;
    private String avatarUrl;
    private Integer userId;
}
