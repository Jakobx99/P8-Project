package sw801.remindersystem.data.Model.Persistence.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sw801.remindersystem.data.Model.Persistence.Entity.SmartDevice;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */

@Dao
public interface SmartDeviceDao {
    @Query("SELECT * FROM smartdevice")
    List<SmartDevice> getAll();

    @Query("SELECT * FROM smartdevice WHERE id IN (:smartDeviceIds)")
    List<SmartDevice> loadAllByIds(Integer[] smartDeviceIds);

    @Query("SELECT * FROM smartdevice WHERE id == :smartDeviceId LIMIT 1")
    SmartDevice loadById(Integer smartDeviceId);

    @Query("SELECT COUNT(*) from smartdevice")
    Integer count();

    @Insert
    void insertAll(SmartDevice... smartDevices);

    @Insert
    void insert(SmartDevice smartDevice);

    @Update
    void update(SmartDevice smartDevice);

    @Delete
    void delete(SmartDevice smartDevice);
}
