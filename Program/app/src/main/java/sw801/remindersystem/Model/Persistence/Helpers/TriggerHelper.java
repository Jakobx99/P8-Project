package sw801.remindersystem.Model.Persistence.Helpers;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import sw801.remindersystem.data.Model.Persistence.Database.AppDatabase;
import sw801.remindersystem.data.Model.Persistence.Entity.Trigger;
import sw801.remindersystem.data.Model.Persistence.Helpers.DbHelper;

/**
 * Created by Kasper Helsted on 3/26/2018.
 */

@Singleton
public class TriggerHelper implements DbHelper<Trigger> {
    private final AppDatabase mAppDatabase;

    @Inject
    public TriggerHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<List<Trigger>> getAll() {
        return Observable.fromCallable(new Callable<List<Trigger>>() {
            @Override
            public List<Trigger> call() throws Exception {
                return mAppDatabase.triggerDao().getAll();
            }
        });
    }

    @Override
    public Observable<List<Trigger>> getByIds(final Integer[] ids) {
        return Observable.fromCallable(new Callable<List<Trigger>>() {
            @Override
            public List<Trigger> call() throws Exception {
                return mAppDatabase.triggerDao().loadAllByIds(ids);
            }
        });
    }

    @Override
    public Observable<Trigger> getById(final Integer id) {
        return Observable.fromCallable(new Callable<Trigger>() {
            @Override
            public Trigger call() throws Exception {
                return mAppDatabase.triggerDao().loadById(id);
            }
        });
    }

    @Override
    public Observable<Integer> getCount() {
        return Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return mAppDatabase.triggerDao().count();
            }
        });
    }

    @Override
    public Observable<Boolean> isEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return mAppDatabase.triggerDao().count() == 0;
            }
        });
    }

    @Override
    public Observable<Boolean> insert(final Trigger obj) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.triggerDao().insert(obj);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> insertAll(final Trigger... obj) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.triggerDao().insertAll(obj);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> update(final Trigger obj) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.triggerDao().update(obj);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> delete(final Trigger obj) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.triggerDao().delete(obj);
                return true;
            }
        });
    }
}
