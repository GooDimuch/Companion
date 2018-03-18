package com.example.dimuch.companion.data.remote;

import com.example.dimuch.companion.data.model.FirebaseRepository;
import com.example.dimuch.companion.data.model.Store;
import java.util.List;
import rx.Observable;

/**
 * Created by Dimuch on 27.09.2017.
 */

public class RestApi {

  private FirebaseRepository mFirebaseRepository;

  public RestApi(FirebaseRepository firebaseRepository) {
    mFirebaseRepository = firebaseRepository;
  }

  public Observable<List<Store>> getStoreList() {
    return mFirebaseRepository.getStoreList();
  }
}
