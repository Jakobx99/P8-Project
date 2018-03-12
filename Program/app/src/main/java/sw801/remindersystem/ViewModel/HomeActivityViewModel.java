package sw801.remindersystem.ViewModel;

import android.content.Intent;



/**
 * Created by Jakob on 12-03-2018.
 */

public class HomeActivityViewModel implements ViewModel {


    @Override
    public void onCreate() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {
    }

    public Integer onClickCreate(Integer i){
        return ++i;
    }

}
