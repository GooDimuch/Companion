package com.example.dimuch.companion.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by vrungel on 14.03.2018.
 */

public class StoreList {
  private @SerializedName("StoreList") List<Store> StoreList;

  public List<Store> getStores() {
    return StoreList;
  }
}
