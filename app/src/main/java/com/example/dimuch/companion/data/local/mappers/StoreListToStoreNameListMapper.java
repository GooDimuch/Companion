package com.example.dimuch.companion.data.local.mappers;

import com.example.dimuch.companion.data.model.Store;
import com.example.dimuch.companion.data.model.StoreName;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;

/**
 * Created by Dimuch on 13.10.2017.
 */

public class StoreListToStoreNameListMapper implements Mapper<List<Store>, List<StoreName>> {

  private List<Store> mStoreList  = new ArrayList<>();
  private List<StoreName> mStoreNameList  = new ArrayList<>();

  @Override public List<StoreName> transform(List<Store> storeList) throws RuntimeException {
    mStoreList = storeList;

    Observable.from(storeList).map(Store::getmStoreName).map(s -> {
      StoreName storeName = new StoreName();
      storeName.setmStoreName(s);
      return storeName;
    }).subscribe(mStoreNameList::add);

    return mStoreNameList;
  }
}
