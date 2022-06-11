package murraco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill extends BaseModel {
    private String name;
}
