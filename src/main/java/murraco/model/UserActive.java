package murraco.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Random;

@Entity(name = "user_actives")
@Data
@NoArgsConstructor
public class UserActive extends BaseModel {
    private Integer userId;
    private Integer activeCode;

    public UserActive(Integer userId) {
        this.userId = userId;
        generateActiveCode();
    }

    public void generateActiveCode() {
        this.activeCode = new Random().nextInt(9000) + 1000;
    }
}
