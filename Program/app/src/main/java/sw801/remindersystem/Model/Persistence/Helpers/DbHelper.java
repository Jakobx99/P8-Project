package sw801.remindersystem.Model.Persistence.Helpers;

import android.database.Observable;

import java.util.List;

/**
 * Created by Kasper Helsted on 3/26/2018.
 */

public interface DbHelper<T> {
    Observable<List<T>> getAll();

    Observable<List<T>> getById(Integer id);

    Observable<List<T>> getByIds(Integer[] ids);

    Observable<Integer> getCount();

    Observable<Boolean> isEmpty();

    Observable<Boolean> insert(final T obj);

    Observable<Boolean> insertAll(final T... obj);

    Observable<Boolean> update(final T obj);

    Observable<Boolean> delete(final T obj);
}
