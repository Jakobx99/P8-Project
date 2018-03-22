package sw801.remindersystem.Model.Persistence.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sw801.remindersystem.Model.Persistence.Entity.When;

/**
 * Created by Kasper Helsted on 3/22/2018.
 */

@Dao
public interface WhenDao {
    @Query("SELECT * FROM `when`")
    LiveData<List<When>> getAll();

    @Query("SELECT * FROM `when` WHERE id IN (:whenIds)")
    LiveData<List<When>> loadAllByIds(Integer[] whenIds);

    @Query("SELECT * FROM `when` WHERE id == :whenId LIMIT 1")
    LiveData<When> loadById(Integer whenId);

    @Query("SELECT COUNT(*) from `when`")
    LiveData<Integer> countWhens();

    @Insert
    void insertAll(When... whens);

    @Insert
    void insert(When when);

    @Update
    void update(When when);

    @Delete
    void delete(When when);
}
