package sw801.remindersystem.Model.Persistence.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;

import sw801.remindersystem.Model.Persistence.Entity.Coordinate;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */
@Dao
public interface CoordinateDao {
    @Query("SELECT * FROM coordinate")
    LiveData<ArrayList<Coordinate>> getAll();

    @Query("SELECT * FROM coordinate WHERE id IN (:coordinateIds)")
    LiveData<ArrayList<Coordinate>> loadAllByIds(Integer[] coordinateIds);

    @Query("SELECT * FROM coordinate WHERE id == :coordinateId LIMIT 1")
    LiveData<ArrayList<Coordinate>> loadById(Integer coordinateId);

    @Query("SELECT COUNT(*) from coordinate")
    LiveData<Integer> countCoordinates();

    @Insert
    void insertAll(Coordinate... coordinates);

    @Insert
    void insert(Coordinate coordinate);

    @Update
    void udpate(Coordinate coordinate);

    @Delete
    void delete(Coordinate coordinate);
}
