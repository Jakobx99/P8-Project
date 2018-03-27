package sw801.remindersystem.ui.home;

import android.app.FragmentManager;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import sw801.remindersystem.R;
import sw801.remindersystem.ui.base.BaseActivity;
import sw801.remindersystem.ui.base.BaseFragment;

public class HomeFragment extends BaseFragment<ActivityHomeBinding, HomeViewModel> implements HomeFragmentNavigator, HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProvider.Factory hViewModelFactory;
    private ActivityHomeBinding hActivityMainBinding;
    private HomeViewModel hViewModel;
    private NavigationView mNavigationView;

    //Bruges til at lave en ny intent til en context
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, HomeFragment.class);
        return intent;
    }

    @Override
    public void handleError(Throwable throwable) {
        //Do something...
    }

    /*
    Hvis der skal subscribes til data, bindes det som kan ses herunder.
     */
    private void subscribeToLiveData()
    {
        //HomeViewModel.getQuestionCardData().observe(this, questionCardDatas -> mMainViewModel.setQuestionDataList(questionCardDatas));
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector()
    {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public HomeViewModel getViewModel() {
        return null;
    }
}