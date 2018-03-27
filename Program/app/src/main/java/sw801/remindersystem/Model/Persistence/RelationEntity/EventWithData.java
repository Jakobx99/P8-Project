package sw801.remindersystem.Model.Persistence.RelationEntity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

import sw801.remindersystem.Model.Persistence.Entity.Event;
import sw801.remindersystem.Model.Persistence.Entity.Trigger;
import sw801.remindersystem.Model.Persistence.Entity.When;

/**
 * Created by Kasper Helsted on 3/22/2018.
 */

public class EventWithData {
    @Embedded
    public Event event;

    @Relation(parentColumn = "id", entityColumn = "eventId", entity = When.class)
    public List<WhenWithCoordinate> whens;

    @Relation(parentColumn = "id", entityColumn = "eventId", entity = Trigger.class)
    public List<TriggerWithSmartDevice> triggers;
}
