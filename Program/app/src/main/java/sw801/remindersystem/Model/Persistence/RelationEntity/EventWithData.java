package sw801.remindersystem.Model.Persistence.RelationEntity;

import android.arch.persistence.room.Embedded;

import sw801.remindersystem.Model.Persistence.Entity.Event;

/**
 * Created by Kasper Helsted on 3/22/2018.
 */

public class EventWithData {
    @Embedded
    public Event event;
}
