package com.example.dimuch.companion;

import android.app.Application;
import com.example.dimuch.companion.di.components.AppComponent;
import com.example.dimuch.companion.di.components.DaggerAppComponent;
import com.example.dimuch.companion.di.modules.AppModule;
import timber.log.Timber;

public class App extends Application {

  public static AppComponent getComponent() {
    return component;
  }

  private static AppComponent component;

  @Override public void onCreate() {
    super.onCreate();
    component = buildComponent();

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  private AppComponent buildComponent() {
    return DaggerAppComponent.builder().appModule(new AppModule(this)).build();
  }

}