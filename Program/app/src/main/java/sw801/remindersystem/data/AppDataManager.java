package sw801.remindersystem.data;

import android.content.Context;
import com.google.gson.Gson;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Observable;
import sw801.remindersystem.data.Model.Persistence.Helpers.DbHelper;

/**
 * Created by amitshekhar on 07/07/17.
 */
@Singleton
public class AppDataManager implements DataManager {

    //private final ApiHelper mApiHelper;

    private final Context mContext;

    private final DbHelper mDbHelper;

    private final Gson mGson;

    //private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper,  Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mGson = gson;
    }


    @Override
    public Observable<List> getAll() {
        return null;
    }

    @Override
    public Observable<List> getByIds(Integer[] ids) {
        return null;
    }

    @Override
    public Observable getById(Integer id) {
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
    public Observable<Boolean> insert(Object obj) {
        return null;
    }

    @Override
    public Observable<Boolean> insertAll(Object[] obj) {
        return null;
    }

    @Override
    public Observable<Boolean> update(Object obj) {
        return null;
    }

    @Override
    public Observable<Boolean> delete(Object obj) {
        return null;
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {

    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, String userName, String email, String profilePicPath) {

    }
}
