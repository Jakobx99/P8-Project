package sw801.remindersystem.Model.Persistence.Converter;

import android.arch.persistence.room.TypeConverter;

import sw801.remindersystem.Model.Persistence.Entity.When;

/**
 * Created by Kasper Helsted on 3/22/2018.
 */

public class WeekdayTypeConverter {
    @TypeConverter
    public static When.Weekday toStatus(int status) {
        if (status == When.Weekday.MONDAY.getCode()) {
            return When.Weekday.MONDAY;
        } else if (status == When.Weekday.TUESDAY.getCode()) {
            return When.Weekday.TUESDAY;
        } else if (status == When.Weekday.WEDNESDAY.getCode()) {
            return When.Weekday.WEDNESDAY;
        } else if (status == When.Weekday.THURSDAY.getCode()) {
            return When.Weekday.THURSDAY;
        } else if (status == When.Weekday.FRIDAY.getCode()) {
            return When.Weekday.FRIDAY;
        } else if (status == When.Weekday.SATURDAY.getCode()) {
            return When.Weekday.SATURDAY;
        } else if (status == When.Weekday.SUNDAY.getCode()) {
            return When.Weekday.SUNDAY;
        } else {
            throw new IllegalArgumentException("Could not recognize status");
        }
    }

    @TypeConverter
    public static Integer toInteger(When.Weekday status) {
        return status.getCode();
    }
}
