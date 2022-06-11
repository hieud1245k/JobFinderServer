package murraco.mappers;

import murraco.dto.v1.EmployeeDTO;
import murraco.model.Employee;

public class EmployeeMapper {
    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setAvatarUrl(employee.getAvatarUrl());
        employeeDTO.setCovertImageUrl(employeeDTO.getCovertImageUrl());
        employeeDTO.setCompanyName(employeeDTO.getCompanyName());
        return employeeDTO;
    }

    public static Employee toModel(EmployeeDTO employeeDTO) {
        return null;
    }
}
