package murraco.dto.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipDTO {
    private String title;
    private String content;
    private String authorName;
    private String authorPosition;
    private String avatarUrl;
    private String tipColor;
}
