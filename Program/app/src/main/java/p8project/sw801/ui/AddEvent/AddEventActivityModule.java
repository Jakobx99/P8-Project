package p8project.sw801.ui.AddEvent;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import p8project.sw801.ViewModelProviderFactory;
import p8project.sw801.data.DataManager;
import p8project.sw801.utils.rx.SchedulerProvider;

@Module
public class AddEventActivityModule {
    @Provides
    ViewModelProvider.Factory AddEventViewModelProvider(AddEventViewModel AddEventViewModel) {
        return new ViewModelProviderFactory<>(AddEventViewModel);
    }

    @Provides
    AddEventViewModel provideAddEventViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new AddEventViewModel(dataManager, schedulerProvider);
    }
}
