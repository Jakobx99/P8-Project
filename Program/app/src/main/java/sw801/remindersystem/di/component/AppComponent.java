package sw801.remindersystem.di.component;
import android.app.Application;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import sw801.remindersystem.MvvmApp;
import sw801.remindersystem.di.builder.ActivityBuilder;
import sw801.remindersystem.di.module.AppModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}