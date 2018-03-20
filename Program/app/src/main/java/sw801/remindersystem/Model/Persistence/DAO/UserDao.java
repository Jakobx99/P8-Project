package sw801.remindersystem.Model.Persistence.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import sw801.remindersystem.Model.Persistence.Entity.User;

/**
 * Created by Kasper Helsted on 3/15/2018.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    LiveData<List<User>> loadAllByIds(Integer[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    LiveData<User> findByName(String first, String last);

    @Query("SELECT * FROM user WHERE id == :userId LIMIT 1")
    LiveData<List<User>> loadById(Integer userId);

    @Query("SELECT COUNT(*) from user")
    LiveData<Integer> countUsers();

    @Insert
    void insertAll(User... users);

    @Update
    void udpate(User user);

    @Delete
    void delete(User user);
}