package com.example.dimuch.companion.di.components;

import com.example.dimuch.companion.di.modules.AppModule;
import com.example.dimuch.companion.feature.googleLogin.SocialUser;
import com.example.dimuch.companion.feature.main.MainActivityPresenter;
import com.example.dimuch.companion.feature.profile.ProfileActivityPresenter;
import com.example.dimuch.companion.feature.store.StoreActivityPresenter;
import com.example.dimuch.companion.feature.storeList.StoreListActivityPresenter;
import com.example.dimuch.companion.feature.splash.SplashActivityPresenter;
import dagger.Component;
import javax.inject.Singleton;


@Component(modules = AppModule.class) @Singleton public interface AppComponent {

  void inject(MainActivityPresenter mPresenter);

  void inject(ProfileActivityPresenter mPresenter);

  void inject(SplashActivityPresenter mPresenter);

  void inject(StoreListActivityPresenter mPresenter);

  void inject(StoreActivityPresenter mPresenter);

  void inject(SocialUser mPresenter);
}