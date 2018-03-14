package com.example.dimuch.companion.feature.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.companion.App;
import com.example.dimuch.companion.feature.views.IMainActivityView;

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
