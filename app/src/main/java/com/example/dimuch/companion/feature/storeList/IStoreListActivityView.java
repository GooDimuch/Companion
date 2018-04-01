package com.example.dimuch.companion.feature.storeList;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.dimuch.companion.data.model.Store;
import java.util.List;

/**
 * Created by Dimuch on 27.11.2017.
 */

@StateStrategyType(AddToEndStrategy.class) public interface IStoreListActivityView extends MvpView {

  void updateDataInList(List<Store> storeNameList);

  void showToast(String sToastMessage);

  void updateDataInListBySearch(List<Store> stores);
}
