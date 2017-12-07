package com.example.dimuch.companion.utils;

import com.example.dimuch.companion.App;
import com.example.dimuch.companion.data.DataManager;
import com.example.dimuch.companion.data.model.StoreName;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Dimuch on 28.11.2017.
 */

public class StoreListHelper {

  @Inject DataManager mDataManager;
  private List<String> mStoreList;

  public StoreListHelper() {
    App.getComponent().inject(this);
    mStoreList = new ArrayList<>();
  }

  public List<String> getmStoreList() {

    return testListForRV();
  }

  public void setmStoreList(List<String> mStoreList) {
    this.mStoreList = mStoreList;
  }

  public List<String> getListYouAreLookingFor(String searchedCombination) {
    List<String> list = new ArrayList<>();

    Observable.from(getmStoreList())
        .filter(s -> s.toLowerCase().contains(searchedCombination.toLowerCase()))
        .subscribe(list::add);

    return searchedCombination.isEmpty() ? getmStoreList() : list;
  }

  private List<String> testListForRV() {
    List<String> list = new ArrayList<>();

    mDataManager.getStoreNameList()
        .flatMap(Observable::from)
        .map(StoreName::getmStoreName)
        .subscribe(list::add);

    return list;
  }

  //private List<String> testListForRV() {
  //  List<String> testList = new ArrayList<>();
  //  for (int i = 0; i < 25; i++) {
  //    testList.add("Магазин №" + i);
  //  }
  //  return testList;
  //}
}
