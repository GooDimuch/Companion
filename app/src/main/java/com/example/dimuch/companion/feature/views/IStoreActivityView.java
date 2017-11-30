package com.example.dimuch.companion.feature.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Dimuch on 27.11.2017.
 */

@StateStrategyType(AddToEndStrategy.class) public interface IStoreActivityView extends MvpView {

  void showToast(String sToastMessage);
}
