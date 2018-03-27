package sw801.remindersystem.ui.home;

public interface HomeFragmentNavigator {
    //Herinde deklarares de metoder som SKAL implementeres som en del af et interface; handleError skal være der til exceptions
    //Derudover så primært metoder som der åbner andre activities/fragments, eksempel udkommenret.

    //void openLoginActivity();

    void handleError(Throwable throwable);
}

