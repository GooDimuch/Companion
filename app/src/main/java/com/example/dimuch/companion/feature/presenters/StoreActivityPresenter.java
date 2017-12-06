package com.example.dimuch.companion.feature.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.companion.feature.views.IStoreActivityView;

/**
 * Created by Dimuch on 27.11.2017.
 */

@InjectViewState public class StoreActivityPresenter extends MvpPresenter<IStoreActivityView> {

  public StoreActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
  }
}
