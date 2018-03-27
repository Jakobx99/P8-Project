package sw801.remindersystem.data;

import sw801.remindersystem.data.Model.Persistence.Helpers.DbHelper;

/**
 * Created by amitshekhar on 07/07/17.
 */

public interface DataManager extends DbHelper{
        //, PreferencesHelper, ApiHelper {
    //todo db
    //Observable<Boolean> seedDatabaseOptions();
    //Observable<Boolean> seedDatabaseQuestions();

    void updateApiHeader(Long userId, String accessToken);

    void updateUserInfo(
            String accessToken,
            Long userId,
            String userName,
            String email,
            String profilePicPath);
}
