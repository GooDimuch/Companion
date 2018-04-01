package com.example.dimuch.companion.feature.store;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.companion.App;
import com.example.dimuch.companion.data.DataManager;
import com.example.dimuch.companion.data.model.Store;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Dimuch on 27.11.2017.
 */

@InjectViewState public class StoreActivityPresenter extends MvpPresenter<IStoreActivityView> {

  @Inject DataManager mDataManager;
  private List<Store> mStoreList;
  private int idStore;

  public StoreActivityPresenter() {
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    App.getComponent().inject(this);

    mStoreList = new ArrayList<>();
    mDataManager.getStoreList().subscribe(mStoreList::addAll);

    fillAllView(searchStoreById(idStore));
  }

  private Store searchStoreById(int idStore) {
    for (Store store : mStoreList) {
      if (store.getId() == idStore) return store;
    }
    return null;
  }

  public void transmitStoreId(int idStore) {
    this.idStore = idStore;
  }

  private void fillAllView(Store store) {
    getViewState().setLogoStore(store.getLogoStore());
    getViewState().setNameStore(store.getName());
    getViewState().setRatingStore((float) store.getRating());
    getViewState().setTypeStore(store.getType());
    getViewState().setAddressStore(store.getAddress());
    getViewState().setWebSiteStore(store.getWebsite());
    getViewState().setPhoneStore(store.getPhone());
    getViewState().setWorkScheduleStore(store.getWorkSchedule());
  }
}
