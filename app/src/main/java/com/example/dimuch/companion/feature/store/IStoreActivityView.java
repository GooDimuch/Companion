package com.example.dimuch.companion.feature.store;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Dimuch on 27.11.2017.
 */

@StateStrategyType(AddToEndStrategy.class) public interface IStoreActivityView extends MvpView {

  void showToast(String sToastMessage);

  void setLogoStore(int iLogoStore);

  void setNameStore(String sNameStore);

  void setRatingStore(float fRatingStore);

  void setTypeStore(String sTypeStore);

  void setAddressStore(String sAddressStore);

  void setWebSiteStore(String sWebSiteStore);

  void setPhoneStore(String sPhoneStore);

  void setWorkScheduleStore(String sWorkScheduleStore);
}
