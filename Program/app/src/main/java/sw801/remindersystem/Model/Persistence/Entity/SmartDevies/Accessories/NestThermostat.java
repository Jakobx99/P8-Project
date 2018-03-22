package sw801.remindersystem.Model.Persistence.Entity.SmartDevies.Accessories;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import sw801.remindersystem.Model.Persistence.Entity.SmartDevies.Controllers.NestHub;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */
@Entity(foreignKeys = @ForeignKey(
        entity = NestHub.class, parentColumns = "id", childColumns = "nest_hub_id", onDelete = CASCADE
))
public class NestThermostat {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "nest_hub_id")
    private Integer nestHubId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "deviceId")
    private Integer deviceId;
}
