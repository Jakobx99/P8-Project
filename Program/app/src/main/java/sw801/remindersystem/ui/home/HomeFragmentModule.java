package sw801.remindersystem.ui.home;
import android.arch.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;
import sw801.remindersystem.Utils.Rx.SchedulerProvider;
import sw801.remindersystem.ViewModelProviderFactory;
import sw801.remindersystem.data.DataManager;

//Dette module indikere den binding der er i viewmodellen.
@Module
public class HomeFragmentModule {

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(HomeViewModel homeViewModel) {
        return new ViewModelProviderFactory<>(homeViewModel);
    }

    @Provides
    HomeViewModel provideMainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new HomeViewModel(dataManager, schedulerProvider);
    }
}