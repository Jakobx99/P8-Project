package sw801.remindersystem.Model.Persistence.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import sw801.remindersystem.Model.Persistence.DAO.UserDao;
import sw801.remindersystem.Model.Persistence.Entity.User;

/**
 * Created by Kasper Helsted on 3/15/2018.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "db-name";
    private static AppDatabase DATABASE_INSTANCE = null;

    public static AppDatabase getDatabase(Context context) {
        if (DATABASE_INSTANCE == null)
            DATABASE_INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DATABASE_NAME
            ).build();


        return DATABASE_INSTANCE;
    }

    public abstract UserDao userDao();
}