package sw801.remindersystem.di.builder;
//todo Import Ui's; Examples below
//import com.mindorks.framework.mvvm.ui.about.AboutFragmentProvider;
//import com.mindorks.framework.mvvm.ui.feed.FeedActivity;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import sw801.remindersystem.ActivityView.Activity.MainActivity;

/**
 * Created by amitshekhar on 14/09/17.
 */
@Module
public abstract class ActivityBuilder {

    //@ContributesAndroidInjector(modules = LoginActivityModule.class)
    //abstract LoginActivity bindLoginActivity();
    //Example of how to setup
   // @ContributesAndroidInjector(modules = {
   //         MainActivityModule.class,
   //         AboutFragmentProvider.class
    //        RateUsDialogProvider.class})
    //abstract MainActivity bindMainActivity();

    //@ContributesAndroidInjector(modules = SplashActivityModule.class)
    //abstract SplashActivity bindSplashActivity();
}