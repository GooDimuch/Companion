package com.example.dimuch.companion.feature.storeList;

import com.arellomobile.mvp.InjectViewState;
import com.example.dimuch.companion.App;
import com.example.dimuch.companion.base.BasePresenter;
import com.example.dimuch.companion.data.model.Store;
import com.example.dimuch.companion.utils.ThreadSchedulers;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscription;

/**
 * Created by Dimuch on 27.11.2017.
 */

@InjectViewState public class StoreListActivityPresenter
    extends BasePresenter<IStoreListActivityView> {

  private List<Store> mStoreList;

  @Override protected void inject() {
    App.getComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();

    mStoreList = new ArrayList<>();
    updateDataInList();
    //getViewState().updateDataInList(downloadDataForList());
  }

  private void updateDataInList() {
    if (!mStoreList.isEmpty()) getViewState().updateDataInList(mStoreList);
    Subscription subscription = mDataManager.getStoreList()
        .compose(ThreadSchedulers.applySchedulers()) // тут просто распаралеливаем задачи по потокам
        .subscribe(stores -> {
          mStoreList.addAll(stores);
          getViewState().updateDataInList(stores);
        });
    addToUnsubscription(subscription);
  }

  //private List<Store> downloadDataForList() {
  //  if (!mStoreList.isEmpty()) return mStoreList;
  //
  //  mDataManager.getStoreList().subscribe(mStoreList::addAll);
  //
  //  return mStoreList;
  //}

  public List<Store> getListYouAreLookingFor(String searchedCombination) {
    List<Store> list = new ArrayList<>();

    Observable.from(mStoreList)
        .filter(store -> store.getName().toLowerCase().contains(searchedCombination.toLowerCase()))
        .subscribe(list::add);

    return searchedCombination.isEmpty() ? mStoreList : list;
  }
}
