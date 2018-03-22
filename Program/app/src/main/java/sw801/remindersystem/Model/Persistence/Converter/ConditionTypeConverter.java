package sw801.remindersystem.Model.Persistence.Converter;

import android.arch.persistence.room.TypeConverter;

import sw801.remindersystem.Model.Persistence.Entity.When;

/**
 * Created by Kasper Helsted on 3/22/2018.
 */

public class ConditionTypeConverter {
    @TypeConverter
    public static When.Condition toStatus(int status) {
        if (status == When.Condition.I_ARRIVE.getCode()) {
            return When.Condition.I_ARRIVE;
        } else if (status == When.Condition.I_LEAVE.getCode()) {
            return When.Condition.I_LEAVE;
        } else if (status == When.Condition.I_AM_NEAR.getCode()) {
            return When.Condition.I_AM_NEAR;
        } else if (status == When.Condition.I_AM_AT.getCode()) {
            return When.Condition.I_AM_AT;
        } else if (status == When.Condition.NOT_AT_LOCATION.getCode()) {
            return When.Condition.NOT_AT_LOCATION;
        } else {
            throw new IllegalArgumentException("Could not recognize status");
        }
    }

    @TypeConverter
    public static Integer toInteger(When.Condition status) {
        return status.getCode();
    }
}
