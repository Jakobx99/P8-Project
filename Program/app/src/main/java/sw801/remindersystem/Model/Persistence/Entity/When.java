package sw801.remindersystem.Model.Persistence.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import sw801.remindersystem.Model.Persistence.Converter.ConditionTypeConverter;
import sw801.remindersystem.Model.Persistence.Converter.WeekdayTypeConverter;

/**
 * Created by Kasper Helsted on 3/22/2018.
 */

@Entity
public class When {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "coordinateId")
    private Integer coordinateId;

    @ColumnInfo(name = "eventId")
    private Integer eventId;

    @ColumnInfo(name = "radius")
    private Integer radius;

    @ColumnInfo(name = "condition")
    @TypeConverters(ConditionTypeConverter.class)
    private Condition condition;

    @ColumnInfo(name = "weekday")
    @TypeConverters(WeekdayTypeConverter.class)
    private Weekday weekday;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "startTime")
    private Long startTime;

    @ColumnInfo(name = "endTime")
    private Long endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoordinateId() {
        return coordinateId;
    }

    public void setCoordinateId(Integer coordinateId) {
        this.coordinateId = coordinateId;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Boolean getRecurring() {
        return weekday != null;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public enum Condition {
        I_ARRIVE(0),
        I_LEAVE(1),
        I_AM_NEAR(2),
        I_AM_AT(3),
        NOT_AT_LOCATION(4);

        private int code;

        Condition(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public enum Weekday {
        MONDAY(2),
        TUESDAY(3),
        WEDNESDAY(4),
        THURSDAY(5),
        FRIDAY(6),
        SATURDAY(7),
        SUNDAY(1);

        private int code;

        Weekday(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
