package sw801.remindersystem.Model.Persistence.Entity.SmartDevies.Accessories;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */

@Entity
public class HueLightbulbRGB {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "hueBridgeId")
    private Integer hueBridgeId;

    @ColumnInfo(name = "deviceName")
    private String deviceName;

    @ColumnInfo(name = "deviceId")
    private Integer deviceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHueBridgeId() {
        return hueBridgeId;
    }

    public void setHueBridgeId(Integer hueBridgeId) {
        this.hueBridgeId = hueBridgeId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
}
