package sw801.remindersystem.Model.Persistence.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;

import sw801.remindersystem.Model.Persistence.Entity.Event;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */

@Dao
public interface EventDao {
    @Query("SELECT * FROM event")
    LiveData<ArrayList<Event>> getAll();

    @Query("SELECT * FROM event WHERE id IN (:eventIds)")
    LiveData<ArrayList<Event>> loadAllByIds(Integer[] eventIds);

    @Query("SELECT * FROM event WHERE id == :eventId LIMIT 1")
    LiveData<ArrayList<Event>> loadById(Integer eventId);

    @Query("SELECT COUNT(*) from event")
    LiveData<Integer> countEvents();

    @Insert
    void insertAll(Event... events);

    @Insert
    void insert(Event event);

    @Update
    void udpate(Event event);

    @Delete
    void delete(Event event);
}
