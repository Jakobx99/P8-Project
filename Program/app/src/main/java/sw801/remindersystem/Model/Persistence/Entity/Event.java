package sw801.remindersystem.Model.Persistence.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */

//TODO: Look at https://android.jlelse.eu/android-architecture-components-room-relationships-bf473510c14a for relation
//TODO: https://developer.android.com/reference/android/arch/persistence/room/Relation.html
@Entity(foreignKeys = @ForeignKey(
        entity = SmartDevice.class, parentColumns = "id", childColumns = "device_id", onDelete = CASCADE
))
public class Event {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "IntentId")
    private String IntentId;

    @ColumnInfo(name = "AlarmID")
    private String AlarmID;
}
