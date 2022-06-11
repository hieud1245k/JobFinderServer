package murraco.enums;

import lombok.Getter;

@Getter
public enum JobType {
    FULL_NAME(1), PAST_TIME(2);

    private final Integer index;
   JobType(Integer index) {
       this.index = index;
   }
}
