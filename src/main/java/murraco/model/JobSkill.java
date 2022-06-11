package murraco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "job_skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSkill extends  BaseModel {
    private String jobId;
    private String skillId;
}
