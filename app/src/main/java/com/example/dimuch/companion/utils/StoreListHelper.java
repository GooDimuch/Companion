package com.example.dimuch.companion.utils;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;

/**
 * Created by Dimuch on 28.11.2017.
 */

public class StoreListHelper {

  private List<String> storeList;

  public StoreListHelper() {
    this.storeList = new ArrayList<>();
  }

  public List<String> getStoreList() {
    return testListForRV();
  }

  public void setStoreList(List<String> storeList) {
    this.storeList = storeList;
  }

  public List<String> getListYouAreLookingFor(String searchedCombination) {
    List<String> list = new ArrayList<>();

    Observable.from(getStoreList())
        .filter(s -> s.toLowerCase().contains(searchedCombination.toLowerCase()))
        .subscribe(list::add);

    return searchedCombination.isEmpty() ? getStoreList() : list;
  }

  private List<String> testListForRV() {
    List<String> testList = new ArrayList<>();
    testList.add("Магазин №1");
    testList.add("Магазин №2");
    testList.add("Магазин №3");
    testList.add("Магазин №4");
    testList.add("Магазин №5");
    testList.add("Магазин №6");
    testList.add("Магазин №7");
    testList.add("Магазин №8");
    testList.add("Магазин №9");
    testList.add("Магазин №10");
    testList.add("Магазин №11");
    testList.add("Магазин №12");
    testList.add("Магазин №13");
    testList.add("Магазин №14");
    testList.add("Магазин №15");
    testList.add("Магазин №16");
    testList.add("Магазин №17");
    testList.add("Магазин №18");
    testList.add("Магазин №19");
    testList.add("Магазин №20");
    testList.add("Магазин №21");
    testList.add("Магазин №22");
    testList.add("Магазин №23");
    testList.add("Магазин №24");
    testList.add("Магазин №25");
    testList.add("Магазин №26");
    testList.add("Магазин №27");
    testList.add("Магазин №28");
    testList.add("Магазин №29");
    return testList;
  }
}
