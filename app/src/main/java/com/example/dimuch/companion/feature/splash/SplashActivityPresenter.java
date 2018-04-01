package com.example.dimuch.companion.feature.splash;

import android.os.CountDownTimer;
import com.arellomobile.mvp.InjectViewState;
import com.example.dimuch.companion.App;
import com.example.dimuch.companion.base.BasePresenter;
import com.example.dimuch.companion.data.model.FirebaseRepository;
import javax.inject.Inject;

/**
 * Created by vrungel on 14.03.2018.
 */
@InjectViewState public class SplashActivityPresenter extends BasePresenter<ISplashActivityView> {

  @Inject FirebaseRepository firebaseRepository;

  @Override protected void inject() {
    App.getComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
      @Override public void onTick(long l) {

      }

      @Override public void onFinish() {
        getViewState().moveToNextActivity();
      }
    }.start();
  }
}
