package com.example.dimuch.companion.feature.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.companion.feature.views.IMapActivityView;

/**
 * Created by Dimuch on 27.11.2017.
 */

@InjectViewState public class MapActivityPresenter extends MvpPresenter<IMapActivityView> {

  public MapActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
  }
}
