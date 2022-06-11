package murraco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "applicant_skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantSkill extends BaseModel {
    private Integer applicantId;
    private Integer skillId;
}
