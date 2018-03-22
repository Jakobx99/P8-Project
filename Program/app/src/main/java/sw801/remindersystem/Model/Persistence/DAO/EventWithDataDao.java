package sw801.remindersystem.Model.Persistence.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import sw801.remindersystem.Model.Persistence.RelationEntity.EventWithData;

/**
 * Created by Kasper Helsted on 3/22/2018.
 */

@Dao
public interface EventWithDataDao {
    @Query("SELECT * FROM event")
    LiveData<List<EventWithData>> getEventsWithData();

    @Query("SELECT * FROM event WHERE id == :id")
    LiveData<EventWithData> getEventWithData(Integer id);
}
