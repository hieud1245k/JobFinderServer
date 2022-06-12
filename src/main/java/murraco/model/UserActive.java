package murraco.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Random;

@Entity(name = "user_actives")
@Data
public class UserActive extends BaseModel {
    private Integer userId;
    private Integer activeCode = new Random().nextInt(9000) + 1000;

    public UserActive(Integer userId) {
        this.userId = userId;
    }
}
