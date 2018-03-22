package sw801.remindersystem.Model.Persistence.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import sw801.remindersystem.Model.Persistence.Converter.DateTypeConverter;
import sw801.remindersystem.Model.Persistence.DAO.CoordinateDao;
import sw801.remindersystem.Model.Persistence.DAO.EventDao;
import sw801.remindersystem.Model.Persistence.DAO.GlobalMuteDao;
import sw801.remindersystem.Model.Persistence.DAO.PredefinedLocationDao;
import sw801.remindersystem.Model.Persistence.DAO.SmartDeviceDao;
import sw801.remindersystem.Model.Persistence.Entity.Coordinate;
import sw801.remindersystem.Model.Persistence.Entity.Event;
import sw801.remindersystem.Model.Persistence.Entity.GlobalMute;
import sw801.remindersystem.Model.Persistence.Entity.PredefinedLocation;
import sw801.remindersystem.Model.Persistence.Entity.SmartDevice;

/**
 * Created by Kasper Helsted on 3/15/2018.
 */

@Database(entities = {Coordinate.class, Event.class, GlobalMute.class, PredefinedLocation.class, SmartDevice.class}, version = 1, exportSchema = false)
@TypeConverters({DateTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "database";

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


    public abstract CoordinateDao coordinateDao();

    public abstract EventDao eventDao();

    public abstract GlobalMuteDao globalMuteDao();

    public abstract PredefinedLocationDao predefinedLocationDao();

    public abstract SmartDeviceDao smartDeviceDao();
}