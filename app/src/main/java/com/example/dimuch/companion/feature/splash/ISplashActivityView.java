package com.example.dimuch.companion.feature.splash;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by vrungel on 14.03.2018.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface ISplashActivityView extends MvpView {
  void moveToNextActivity();
}
