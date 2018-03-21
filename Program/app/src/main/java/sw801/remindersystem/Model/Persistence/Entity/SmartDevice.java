package sw801.remindersystem.Model.Persistence.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */
@Entity
public class SmartDevice {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "deviceName")
    private String deviceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
