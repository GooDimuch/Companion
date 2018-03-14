package com.example.dimuch.companion.data.model;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;

/**
 * Created by Dimuch on 07.12.2017.
 */

public class AllData {

  public AllData() {
  }

  public Observable<List<Store>> getStoreList() {
    return Observable.just(createStoreList());
  }

  private List<Store> createStoreList() {
    List<Store> list = new ArrayList<>();
    for (int i = 0; i < 25; i++) {
      Store store = new Store("Магазин №" + i);
      list.add(store);
    }
    return list;
  }
}
