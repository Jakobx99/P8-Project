package sw801.remindersystem.ui.main;

import android.arch.lifecycle.ViewModelProvider;



import dagger.Module;
import dagger.Provides;
import sw801.remindersystem.Utils.Rx.SchedulerProvider;
import sw801.remindersystem.ViewModelProviderFactory;
import sw801.remindersystem.data.DataManager;

/**
 * Created by amitshekhar on 14/09/17.
 */
@Module
public class MainActivityModule {

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

    @Provides
    MainViewModel provideMainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new MainViewModel(dataManager, schedulerProvider);
    }
}

