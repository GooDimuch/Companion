package com.example.dimuch.companion.di.components;

import com.example.dimuch.companion.di.modules.AppModule;
import com.example.dimuch.companion.feature.presenters.MainActivityPresenter;
import com.example.dimuch.companion.feature.presenters.StoreActivityPresenter;
import com.example.dimuch.companion.feature.presenters.StoreListActivityPresenter;
import com.example.dimuch.companion.feature.splash.SplashActivityPresenter;
import dagger.Component;
import javax.inject.Singleton;


@Component(modules = AppModule.class) @Singleton public interface AppComponent {

  void inject(MainActivityPresenter mPresenter);

  //void inject(StoreListHelper mPresenter);

  void inject(SplashActivityPresenter mPresenter);

  void inject(StoreListActivityPresenter storeListActivityPresenter);

  void inject(StoreActivityPresenter storeActivityPresenter);
}