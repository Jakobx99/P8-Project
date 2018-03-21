package sw801.remindersystem.Model.Persistence.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */
@Entity(foreignKeys = @ForeignKey(
        entity = SmartDevice.class, parentColumns = "id", childColumns = "device_id", onDelete = CASCADE
))
public class Event {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "radius")
    private Integer radius;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "recurring")
    private Boolean recurring = false;

    @ColumnInfo(name = "device_id")
    private Integer device_id;

    @ColumnInfo(name = "when")
    private Integer when;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Boolean getRecurring() {
        return recurring;
    }

    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }

    public Integer getWhen() {
        return when;
    }

    public void setWhen(Integer when) {
        this.when = when;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Integer device_id) {
        this.device_id = device_id;
    }
}
