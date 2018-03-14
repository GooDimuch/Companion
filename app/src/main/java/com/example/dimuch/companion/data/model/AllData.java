package com.example.dimuch.companion.data.model;

import com.example.dimuch.companion.R;
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
      Store store = new Store();
      store.setId(i);
      store.setNameStore("Магазин №" + i);
      store.setLogoStore(R.drawable.store);
      store.setRatingStore(7 / 2.0);
      store.setTypeStore("Магазин электроники");
      store.setAddressStore("вулиця Ярославська, 57, Київ, 02000");
      store.setWebSiteStore("rozetka.com.ua");
      store.setPhoneStore("044 503 8080");
      store.setWorkScheduleStore("Открыто:  10–21\n"
          + "понедельник\t10–21\n"
          + "вторник\t10–21\n"
          + "среда\t10–21\n"
          + "четверг\t10–21\n"
          + "пятница\t10–21\n"
          + "суббота\t10–21\n"
          + "воскресенье\t10–18\n");
      list.add(store);
    }
    return list;
  }
}
