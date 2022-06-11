package murraco.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "employee_provinces")
@Data
@NoArgsConstructor
public class EmployeeProvince extends BaseModel {
    private Integer employeeId;
    private Integer provinceId;
}
