package sw801.remindersystem.ui.home;

import android.databinding.ObservableField;
import sw801.remindersystem.Utils.Rx.SchedulerProvider;
import sw801.remindersystem.data.DataManager;
import sw801.remindersystem.ui.base.BaseViewModel;

import static sw801.remindersystem.ui.main.MainViewModel.*;

public class HomeViewModel extends BaseViewModel<HomeFragmentNavigator> {
    //Class variables
    private final ObservableField<String> appVersion = new ObservableField<>();
    private int action = NO_ACTION;
    //private final MutableLiveData<List<QuestionCardData>> questionCardData;                           - Eksempel deklaration
    //private final ObservableList<QuestionCardData> questionDataList = new ObservableArrayList<>();    - Eksempel deklaration



    //Standard constructor
    public HomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        //Hvis der skal loades noget data fra start af, gør det herunder.
        //Eksempel:
        //loadQuestionCards();
    }

    public int getAction() {
        return action;
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

    /*Der laves "get-setters" til de fields du skal have fat på/sette
    //Eksempel i udkommenteret kode.

    public MutableLiveData<List<QuestionCardData>> getQuestionCardData() {
        return questionCardData;
    }

    public ObservableList<QuestionCardData> getQuestionDataList() {
        return questionDataList;
    }

    public void setQuestionDataList(List<QuestionCardData> questionCardDatas) {
        action = ACTION_ADD_ALL;
        questionDataList.clear();
        questionDataList.addAll(questionCardDatas);
    }

     public void loadQuestionCards() {
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
    }
*/


}
