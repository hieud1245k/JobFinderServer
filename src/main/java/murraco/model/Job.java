package murraco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import murraco.enums.JobStateType;
import murraco.enums.JobType;

import javax.persistence.Entity;

@Entity(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job extends BaseModel {
    private String title;
    private String description;
    private Double salary;
    private String provinces;
    private JobType jobType;
    private JobStateType jobStateType = JobStateType.INACTIVE;
    private String requirements;
}
