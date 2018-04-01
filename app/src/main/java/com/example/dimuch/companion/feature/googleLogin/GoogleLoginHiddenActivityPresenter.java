package com.example.dimuch.companion.feature.googleLogin;

import com.arellomobile.mvp.InjectViewState;
import com.example.dimuch.companion.App;
import com.example.dimuch.companion.base.BasePresenter;
import com.example.dimuch.companion.data.model.Profile;
import javax.inject.Inject;

@InjectViewState public class GoogleLoginHiddenActivityPresenter
    extends BasePresenter<IGoogleLoginHiddenActivityView> {
  @Inject Profile mProfile;

  @Override protected void inject() {
    App.getComponent().inject(this);
  }

  public void setUser(Profile profile) {
    mProfile.setName(profile.getName());
    mProfile.setFirstName(profile.getFirstName());
    mProfile.setLastName(profile.getLastName());
    mProfile.setEmail(profile.getEmail());
    mProfile.setPageLink(profile.getPageLink());
    mProfile.setPhotoUrl(profile.getPhotoUrl());
    mProfile.setFavoriteStoresList(profile.getFavoriteStoresList());
  }
}
