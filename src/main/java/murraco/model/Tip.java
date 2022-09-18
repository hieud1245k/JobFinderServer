package murraco.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity(name = "tips")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tip extends BaseModel {
    private String title;
    private String content;
    private String authorName;
    private String authorPosition;
    private String avatarUrl;
    private String tipColor;
}
