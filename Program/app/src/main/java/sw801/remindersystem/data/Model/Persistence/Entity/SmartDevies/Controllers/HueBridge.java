package sw801.remindersystem.data.Model.Persistence.Entity.SmartDevies.Controllers;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import sw801.remindersystem.data.Model.Persistence.Entity.SmartDevice;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */

@Entity
public class HueBridge extends SmartDevice {
    @ColumnInfo(name = "deviceIP")
    private String deviceIP;

    @ColumnInfo(name = "deviceToken")
    private String deviceToken;

    @ColumnInfo(name = "deviceMac")
    private String deviceMac;

    public String getDeviceIP() {
        return deviceIP;
    }

    public void setDeviceIP(String deviceIP) {
        this.deviceIP = deviceIP;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }
}
