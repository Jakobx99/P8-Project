package sw801.remindersystem.Model.Persistence.Entity.SmartDevies.Accessories;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */

@Entity
public class HueLightbulbWhite {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "hueBridgeId")
    private Integer hueBridgeId;

    @ColumnInfo(name = "deviceName")
    private String deviceName;


    @ColumnInfo(name = "deviceId")
    private Integer deviceId;
}
