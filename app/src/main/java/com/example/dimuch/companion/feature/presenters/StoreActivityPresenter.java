package com.example.dimuch.companion.feature.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.dimuch.companion.App;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.data.DataManager;
import com.example.dimuch.companion.data.model.Store;
import com.example.dimuch.companion.feature.views.IStoreActivityView;
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

    fillAllView();
  }

  public void transmitStoreId(int idStore) {
    this.idStore = idStore;
  }

  private void fillAllView() {
    getViewState().setLogoStore(mStoreList.get(idStore).getLogoStore());
    getViewState().setNameStore(mStoreList.get(idStore).getNameStore());
    getViewState().setRatingStore(mStoreList.get(idStore).getRatingStore());
    getViewState().setTypeStore(mStoreList.get(idStore).getTypeStore());
    getViewState().setAddressStore(mStoreList.get(idStore).getAddressStore());
    getViewState().setWebSiteStore(mStoreList.get(idStore).getWebSiteStore());
    getViewState().setPhoneStore(mStoreList.get(idStore).getPhoneStore());
    getViewState().setWorkScheduleStore(mStoreList.get(idStore).getWorkScheduleStore());
  }
}
