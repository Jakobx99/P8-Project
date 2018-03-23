package sw801.remindersystem.Model.Persistence.RelationEntity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

import sw801.remindersystem.Model.Persistence.Entity.SmartDevice;
import sw801.remindersystem.Model.Persistence.Entity.Trigger;

/**
 * Created by Kasper Helsted on 3/22/2018.
 */

public class TriggerWithSmartDevice {
    @Embedded
    public Trigger trigger;

    @Relation(parentColumn = "smartDeviceId", entityColumn = "id", entity = SmartDevice.class)
    public List<SmartDevice> smartDevice;
}
