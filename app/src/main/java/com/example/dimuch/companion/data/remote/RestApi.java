package com.example.dimuch.companion.data.remote;

import com.example.dimuch.companion.data.model.AllData;
import com.example.dimuch.companion.data.model.Store;
import java.util.List;
import rx.Observable;

/**
 * Created by Dimuch on 27.09.2017.
 */

public class RestApi {

  private AllData mAllData;

  public RestApi(AllData allData) {
    mAllData = allData;
  }

  public Observable<List<Store>> getStoreList() {
    return mAllData.getStoreList();
  }
}
