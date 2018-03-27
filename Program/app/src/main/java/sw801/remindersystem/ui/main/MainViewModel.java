package sw801.remindersystem.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.text.TextUtils;
import java.util.List;

import sw801.remindersystem.Utils.Rx.SchedulerProvider;
import sw801.remindersystem.data.DataManager;
import sw801.remindersystem.ui.base.BaseViewModel;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    public static final int NO_ACTION = -1, ACTION_ADD_ALL = 0, ACTION_DELETE_SINGLE = 1;

    private final ObservableField<String> appVersion = new ObservableField<>();

    private int action = NO_ACTION;

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        //Data der skal hentes on-start hentes herunder;
        //Eksempel er udkommenteret!

        //questionCardData = new MutableLiveData<>();
        //loadQuestionCards();
    }
    /*public void loadQuestionCards() {
        getCompositeDisposable().add(getDataManager()
                .getQuestionCardData()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(questionList -> {
                    if (questionList != null) {
                        action = ACTION_ADD_ALL;
                        questionCardData.setValue(questionList);
                    }
                }, throwable -> {

                }));
    }*/

    public int getAction() {
        return action;
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }
}
