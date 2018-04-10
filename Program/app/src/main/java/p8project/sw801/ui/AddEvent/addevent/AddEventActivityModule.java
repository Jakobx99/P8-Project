package p8project.sw801.ui.AddEvent.addevent;

import dagger.Module;
import dagger.Provides;
import p8project.sw801.data.DataManager;
import p8project.sw801.utils.rx.SchedulerProvider;

@Module
public class AddEventActivityModule {
    @Provides
    AddEventActivityViewModel provideAddEventActivityViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        return new AddEventActivityViewModel(dataManager, schedulerProvider);
    }
}
