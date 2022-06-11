package murraco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseModel {
    private String companyName;
    private String establishedDate;
    private String companyAddress;
    private String avatarUrl;
    private String coverImageUrl;
    private Integer userId;
}
