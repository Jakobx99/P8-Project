package sw801.remindersystem.Model.Persistence.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import sw801.remindersystem.Model.Persistence.Entity.PredefinedLocation;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */

@Dao
public interface PredefinedLocationDao {
    @Query("SELECT * FROM predefinedlocation")
    LiveData<List<PredefinedLocation>> getAll();

    @Query("SELECT * FROM predefinedlocation WHERE id IN (:predefinedLocationIds)")
    LiveData<List<PredefinedLocation>> loadAllByIds(Integer[] predefinedLocationIds);

    @Query("SELECT * FROM predefinedlocation WHERE id == :predefinedLocationId LIMIT 1")
    LiveData<List<PredefinedLocation>> loadById(Integer predefinedLocationId);

    @Query("SELECT COUNT(*) from predefinedlocation")
    LiveData<Integer> countPredefinedLocations();

    @Insert
    void insertAll(PredefinedLocation... predefinedLocations);

    @Insert
    void insert(PredefinedLocation predefinedLocation);

    @Update
    void udpate(PredefinedLocation predefinedLocation);

    @Delete
    void delete(PredefinedLocation predefinedLocation);
}
