package sw801.remindersystem.Model.Persistence.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import sw801.remindersystem.Model.Persistence.Entity.GlobalMute;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */

@Dao
public interface GlobalMuteDao {
    @Query("SELECT * FROM globalmute")
    LiveData<List<GlobalMute>> getAll();

    @Query("SELECT * FROM globalmute WHERE id IN (:globalMuteIds)")
    LiveData<List<GlobalMute>> loadAllByIds(Integer[] globalMuteIds);

    @Query("SELECT * FROM globalmute WHERE id == :globalMuteId LIMIT 1")
    LiveData<GlobalMute> loadById(Integer globalMuteId);

    @Query("SELECT COUNT(*) from globalmute")
    LiveData<Integer> countGlobalMutes();

    @Insert
    void insertAll(GlobalMute... globalMutes);

    @Insert
    void insert(GlobalMute globalMute);

    @Update
    void udpate(GlobalMute globalMute);

    @Delete
    void delete(GlobalMute globalMute);
}
