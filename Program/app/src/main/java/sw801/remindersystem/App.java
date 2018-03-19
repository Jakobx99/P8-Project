package sw801.remindersystem;

import android.app.Application;

import sw801.remindersystem.Model.Persistence.Database.AppDatabase;

/**
 * Created by Hellsted on 3/19/2018.
 */

public class App extends Application {
    public static App INSTANCE;
    private AppDatabase DATABASE;

    public static App get() {
        return INSTANCE;
    }

    public AppDatabase getDB() {
        return DATABASE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DATABASE = AppDatabase.getDatabase(this);

        INSTANCE = this;
    }


}
