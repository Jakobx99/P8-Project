package sw801.remindersystem.Model.Persistence.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */

//TODO: Look at https://android.jlelse.eu/android-architecture-components-room-relationships-bf473510c14a for relation
//TODO: https://developer.android.com/reference/android/arch/persistence/room/Relation.html
//@Entity(foreignKeys = @ForeignKey(
//        entity = SmartDevice.class, parentColumns = "id", childColumns = "deviceId", onDelete = CASCADE
//))

@Entity
public class Event {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "IntentId")
    private String IntentId;

    @ColumnInfo(name = "AlarmID")
    private String AlarmID;

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

    public String getIntentId() {
        return IntentId;
    }

    public void setIntentId(String intentId) {
        IntentId = intentId;
    }

    public String getAlarmID() {
        return AlarmID;
    }

    public void setAlarmID(String alarmID) {
        AlarmID = alarmID;
    }
}
