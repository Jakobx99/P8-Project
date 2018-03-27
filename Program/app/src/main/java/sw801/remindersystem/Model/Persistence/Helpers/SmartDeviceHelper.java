package sw801.remindersystem.Model.Persistence.Helpers;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import sw801.remindersystem.data.Model.Persistence.Database.AppDatabase;
import sw801.remindersystem.data.Model.Persistence.Entity.SmartDevice;
import sw801.remindersystem.data.Model.Persistence.Helpers.DbHelper;

/**
 * Created by Kasper Helsted on 3/26/2018.
 */

@Singleton
public class SmartDeviceHelper implements DbHelper<SmartDevice> {
    private final AppDatabase mAppDatabase;

    @Inject
    public SmartDeviceHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<List<SmartDevice>> getAll() {
        return Observable.fromCallable(new Callable<List<SmartDevice>>() {
            @Override
            public List<SmartDevice> call() throws Exception {
                return mAppDatabase.smartDeviceDao().getAll();
            }
        });
    }

    @Override
    public Observable<List<SmartDevice>> getByIds(final Integer[] ids) {
        return Observable.fromCallable(new Callable<List<SmartDevice>>() {
            @Override
            public List<SmartDevice> call() throws Exception {
                return mAppDatabase.smartDeviceDao().loadAllByIds(ids);
            }
        });
    }

    @Override
    public Observable<SmartDevice> getById(final Integer id) {
        return Observable.fromCallable(new Callable<SmartDevice>() {
            @Override
            public SmartDevice call() throws Exception {
                return mAppDatabase.smartDeviceDao().loadById(id);
            }
        });
    }

    @Override
    public Observable<Integer> getCount() {
        return Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return mAppDatabase.smartDeviceDao().count();
            }
        });
    }

    @Override
    public Observable<Boolean> isEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return mAppDatabase.smartDeviceDao().count() == 0;
            }
        });
    }

    @Override
    public Observable<Boolean> insert(final SmartDevice obj) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.smartDeviceDao().insert(obj);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> insertAll(final SmartDevice... obj) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.smartDeviceDao().insertAll(obj);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> update(final SmartDevice obj) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.smartDeviceDao().update(obj);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> delete(final SmartDevice obj) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.smartDeviceDao().delete(obj);
                return true;
            }
        });
    }
}