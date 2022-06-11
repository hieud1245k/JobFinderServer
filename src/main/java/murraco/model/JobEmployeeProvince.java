package murraco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "job_employee_provinces")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobEmployeeProvince extends BaseModel {
    private Integer employeeProvinceId;
    private Integer jobId;
}
