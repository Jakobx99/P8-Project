package sw801.remindersystem.di.builder;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import sw801.remindersystem.ui.home.HomeFragment;
import sw801.remindersystem.ui.home.HomeFragmentModule;
import sw801.remindersystem.ui.home.*;

@Module
public abstract class ActivityBuilder
{
    @ContributesAndroidInjector(modules = {HomeFragmentModule.class})
    abstract HomeFragment bindHomeActivity();

   // @ContributesAndroidInjector(modules = HomeFragmentModule.class)
   // abstract HomeFragment bindHomeFragment();
}