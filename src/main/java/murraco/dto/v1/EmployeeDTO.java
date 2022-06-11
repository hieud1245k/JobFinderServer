package murraco.dto.v1;

import lombok.Data;

@Data
public class EmployeeDTO extends BaseDTO {
    private String avatarUrl;
    private String covertImageUrl;
    private String companyName;
}
