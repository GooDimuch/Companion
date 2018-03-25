package com.example.dimuch.companion.feature.profile;

import com.example.dimuch.companion.App;
import com.example.dimuch.companion.base.BasePresenter;

/**
 * Created by Dimuch on 25.03.2018.
 */

public class ProfileActivityPresenter extends BasePresenter<IProfileActivityView> {

  @Override protected void inject() {
    App.getComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
  }
}
