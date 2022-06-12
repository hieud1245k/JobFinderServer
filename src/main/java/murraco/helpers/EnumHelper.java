package murraco.helpers;

import murraco.enums.AppUserRole;
import murraco.enums.JobType;

import java.util.Arrays;
import java.util.Objects;

public class EnumHelper {
    public static JobType getJobTypeFromIndex(Integer index) {
        try {
            return Arrays.stream(JobType.values()).filter(jobType -> Objects.equals(jobType.getIndex(), index))
                    .findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }

    public static AppUserRole getUserRoleFromIndex(Integer index) {
        try {
            return Arrays.stream(AppUserRole.values()).filter(jobType -> Objects.equals(jobType.getIndex(), index))
                    .findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }
}
