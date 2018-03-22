package sw801.remindersystem.Model.Persistence.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sw801.remindersystem.Model.Persistence.Entity.Trigger;

/**
 * Created by Kasper Helsted on 3/22/2018.
 */

@Dao
public interface TriggerDao {
    @Query("SELECT * FROM `trigger`")
    LiveData<List<Trigger>> getAll();

    @Query("SELECT * FROM `trigger` WHERE id IN (:triggerIds)")
    LiveData<List<Trigger>> loadAllByIds(Integer[] triggerIds);

    @Query("SELECT * FROM `trigger` WHERE id == :triggerId LIMIT 1")
    LiveData<Trigger> loadById(Integer triggerId);

    @Query("SELECT COUNT(*) from `trigger`")
    LiveData<Integer> countTriggers();

    @Insert
    void insertAll(Trigger... triggers);

    @Insert
    void insert(Trigger trigger);

    @Update
    void update(Trigger trigger);

    @Delete
    void delete(Trigger trigger);
}
