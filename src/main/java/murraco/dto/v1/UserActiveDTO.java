package murraco.dto.v1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserActiveDTO extends BaseDTO {
    private Integer userId;
    private Integer activeCode;
}
