package com.example.dimuch.companion.feature.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.companion.App;

/**
 * Created by Dimuch on 27.11.2017.
 */

@InjectViewState public class MainActivityPresenter extends MvpPresenter<IMainActivityView> {

  public MainActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    App.getComponent().inject(this);
  }
}
