package com.example.dimuch.companion.feature.profile;

import com.arellomobile.mvp.InjectViewState;
import com.example.dimuch.companion.App;
import com.example.dimuch.companion.base.BasePresenter;
import com.example.dimuch.companion.data.model.Profile;
import javax.inject.Inject;

/**
 * Created by Dimuch on 25.03.2018.
 */

@InjectViewState public class ProfileActivityPresenter extends BasePresenter<IProfileActivityView> {

  @Inject Profile profile;

  @Override protected void inject() {
    App.getComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    getViewState().updateProfile(profile);
  }
}
