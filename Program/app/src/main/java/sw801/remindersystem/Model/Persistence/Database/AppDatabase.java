package sw801.remindersystem.Model.Persistence.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import sw801.remindersystem.Model.Persistence.DAO.UserDao;
import sw801.remindersystem.Model.Persistence.Entity.User;

/**
 * Created by Kasper Helsted on 3/15/2018.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
