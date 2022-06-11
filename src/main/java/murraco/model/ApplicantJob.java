package murraco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "applicant_jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantJob extends BaseModel {
    private Integer ApplicantId;
    private Integer jobId;
}
