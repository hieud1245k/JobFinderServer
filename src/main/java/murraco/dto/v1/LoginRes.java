package murraco.dto.v1;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginRes {
    private String accessToken;
}
