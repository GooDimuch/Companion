package com.example.dimuch.companion.di.modules;

import com.example.dimuch.companion.data.DataManager;
import com.example.dimuch.companion.data.model.FirebaseRepository;
import com.example.dimuch.companion.data.remote.RestApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Dimuch on 02.10.2017.
 */
@Module public class DataModule {

  @Provides @Singleton FirebaseRepository provideAllData() {
    return new FirebaseRepository();
  }

  @Provides RestApi provideRestApi(FirebaseRepository firebaseRepository) {
    return new RestApi(firebaseRepository);
  }

  @Provides DataManager provideDataManager(RestApi restApi) {
    return new DataManager(restApi);
  }

  @Provides String provideTestMessage() {
    return new String("test message");
  }
}
