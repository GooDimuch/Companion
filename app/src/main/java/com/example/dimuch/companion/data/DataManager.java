package com.example.dimuch.companion.data;

import com.example.dimuch.companion.data.remote.RestApi;

/**
 * Created by Dimuch on 27.09.2017.
 */

public class DataManager {

  private RestApi mRestApi;
  //private DBHelper mDBHelper;

  public DataManager(RestApi mRestApi) {
    this.mRestApi = mRestApi;
  }
}
