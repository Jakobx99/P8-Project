package sw801.remindersystem.di.module;


import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sw801.remindersystem.Model.Persistence.Helpers.AppDbHelper;
import sw801.remindersystem.Utils.AppConstants;
import sw801.remindersystem.Utils.Rx.AppSchedulerProvider;
import sw801.remindersystem.Utils.Rx.SchedulerProvider;
import sw801.remindersystem.data.AppDataManager;
import sw801.remindersystem.data.DataManager;
import sw801.remindersystem.data.Model.Persistence.Database.AppDatabase;
import sw801.remindersystem.data.Model.Persistence.Helpers.DbHelper;
import sw801.remindersystem.di.DatabaseInfo;
import sw801.remindersystem.di.PreferenceInfo;

@Module
public class AppModule {

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }


    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    AppDbHelper provideDbHelper(AppDbHelper appDbHelper) {
       return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }


    //@Provides
    //@Singleton
    //ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
      //                                                     PreferencesHelper preferencesHelper) {
        //return new ApiHeader.ProtectedApiHeader(
          //      apiKey,
            //    preferencesHelper.getCurrentUserId(),
              //  preferencesHelper.getAccessToken());
    //}

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
