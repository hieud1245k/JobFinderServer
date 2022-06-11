package murraco.dto.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO extends BaseDTO {
    private String title;
    private String description;
    private Double salary;
    private String provinces;
    private Integer jobType;
    private Integer jobStateType;
    private String requirements;
    private EmployeeDTO employeeDTO;
}
