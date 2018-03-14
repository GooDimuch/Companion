package com.example.dimuch.companion.feature.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import java.util.List;

/**
 * Created by Dimuch on 27.11.2017.
 */

@StateStrategyType(AddToEndStrategy.class) public interface IStoreListActivityView extends MvpView {

  void updateDataInList(List<String> storeNameList);

  void showToast(String sToastMessage);
}
