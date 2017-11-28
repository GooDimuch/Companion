package com.example.dimuch.companion.di.components;

import com.example.dimuch.companion.di.modules.AppModule;
import com.example.dimuch.companion.feature.presenters.MainActivityPresenter;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules = AppModule.class) @Singleton public interface AppComponent {

  void inject(MainActivityPresenter mainActivityPresenter);
}