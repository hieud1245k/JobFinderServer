package murraco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import murraco.enums.ApplyState;

import javax.persistence.Entity;

@Entity(name = "job_applicants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicant extends BaseModel {
    private Integer jobId;
    private Integer applicantId;
    private ApplyState applyState;
}
