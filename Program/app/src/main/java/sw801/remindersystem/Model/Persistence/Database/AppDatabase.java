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

    private static volatile AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null)
            instance = create(context);
        return instance;
    }

    private static AppDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                DATABASE_NAME).build();
    }


    public abstract UserDao userDao();

}