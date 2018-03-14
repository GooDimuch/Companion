package com.example.dimuch.companion.feature.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.companion.App;
import com.example.dimuch.companion.data.DataManager;
import com.example.dimuch.companion.data.model.Store;
import com.example.dimuch.companion.feature.views.IStoreListActivityView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import timber.log.Timber;

/**
 * Created by Dimuch on 27.11.2017.
 */

@InjectViewState public class StoreListActivityPresenter
    extends MvpPresenter<IStoreListActivityView> {

  @Inject DataManager mDataManager;
  private List<Store> mStoreList;

  public StoreListActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    App.getComponent().inject(this);

    mStoreList = new ArrayList<>();
    getViewState().updateDataInList(downloadDataForList());
  }

  private List<Store> downloadDataForList() {
    if (!mStoreList.isEmpty()) return mStoreList;

    mDataManager.getStoreList().subscribe(mStoreList::addAll);
    Timber.wtf(mStoreList.toString());

    return mStoreList;
  }

  public List<Store> getListYouAreLookingFor(String searchedCombination) {
    List<Store> list = new ArrayList<>();

    Observable.from(mStoreList)
        .filter(
            store -> store.getNameStore().toLowerCase().contains(searchedCombination.toLowerCase()))
        .subscribe(list::add);

    return searchedCombination.isEmpty() ? mStoreList : list;
  }
}
