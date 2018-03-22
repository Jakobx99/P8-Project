package sw801.remindersystem.Model.Persistence.Entity.SmartDevies.Controllers;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import sw801.remindersystem.Model.Persistence.Entity.SmartDevice;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */

@Entity
public class NestHub extends SmartDevice {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "bearerToken")
    private String bearerToken;
}
