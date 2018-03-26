package sw801.remindersystem.Model.Persistence.Helpers;

import android.database.Observable;

import java.util.List;

import javax.inject.Inject;

import sw801.remindersystem.Model.Persistence.Database.AppDatabase;
import sw801.remindersystem.Model.Persistence.Entity.Coordinate;

/**
 * Created by Kasper Helsted on 3/26/2018.
 */

public class CoordinateHelper implements DbHelper<Coordinate> {
    private final AppDatabase mAppDatabase;

    @Inject
    public CoordinateHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<List<Coordinate>> getAll() {
        return null;
    }

    @Override
    public Observable<List<Coordinate>> getById(Integer id) {
        return null;
    }

    @Override
    public Observable<List<Coordinate>> getByIds(Integer[] ids) {
        return null;
    }

    @Override
    public Observable<Integer> getCount() {
        return null;
    }

    @Override
    public Observable<Boolean> isEmpty() {
        return null;
    }

    @Override
    public Observable<Boolean> insert(Coordinate obj) {
        return null;
    }

    @Override
    public Observable<Boolean> insertAll(Coordinate... obj) {
        return null;
    }

    @Override
    public Observable<Boolean> update(Coordinate obj) {
        return null;
    }

    @Override
    public Observable<Boolean> delete(Coordinate obj) {
        return null;
    }
}
