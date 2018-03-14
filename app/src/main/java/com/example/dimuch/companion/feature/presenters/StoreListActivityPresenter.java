package com.example.dimuch.companion.feature.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.companion.App;
import com.example.dimuch.companion.data.DataManager;
import com.example.dimuch.companion.data.model.StoreName;
import com.example.dimuch.companion.feature.views.IStoreListActivityView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by Dimuch on 27.11.2017.
 */

@InjectViewState public class StoreListActivityPresenter
    extends MvpPresenter<IStoreListActivityView> {

  @Inject DataManager mDataManager;
  private List<String> mStoreList;

  public StoreListActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    App.getComponent().inject(this);

    mStoreList = new ArrayList<>();
    getViewState().updateDataInList(downloadDataForList());
  }

  private List<String> downloadDataForList() {
    if (!mStoreList.isEmpty()) return mStoreList;

    mDataManager.getStoreNameList()
        .flatMap(Observable::from)
        .map(StoreName::getmStoreName)
        .subscribe(mStoreList::add);

    return mStoreList;
  }

  public List<String> getListYouAreLookingFor(String searchedCombination) {
    List<String> list = new ArrayList<>();

    Observable.from(mStoreList)
        .filter(s -> s.toLowerCase().contains(searchedCombination.toLowerCase()))
        .subscribe(list::add);

    return searchedCombination.isEmpty() ? mStoreList : list;
  }
}
