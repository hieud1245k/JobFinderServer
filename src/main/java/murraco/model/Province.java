package murraco.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "provinces.json")
@Data
@NoArgsConstructor
public class Province extends BaseModel {
    private String name;
    private String code;
}
