package com.example.dimuch.companion.data;

import com.example.dimuch.companion.data.local.mappers.StoreListToStoreNameListMapper;
import com.example.dimuch.companion.data.model.Store;
import com.example.dimuch.companion.data.model.StoreName;
import com.example.dimuch.companion.data.remote.RestApi;
import java.util.List;
import rx.Observable;

/**
 * Created by Dimuch on 27.09.2017.
 */

public class DataManager {

  private RestApi mRestApi;
  //private DBHelper mDBHelper;

  public DataManager(RestApi mRestApi) {
    this.mRestApi = mRestApi;
  }

  public Observable<List<Store>> getStoreList() {
    return mRestApi.getStoreList();
  }

  public Observable<List<StoreName>> getStoreNameList() {
    return mRestApi.getStoreList()
        .map(storeList -> (new StoreListToStoreNameListMapper()).transform(storeList));
  }
}
