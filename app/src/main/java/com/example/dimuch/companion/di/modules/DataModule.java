package com.example.dimuch.companion.di.modules;

import com.example.dimuch.companion.data.DataManager;
import com.example.dimuch.companion.data.remote.RestApi;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Dimuch on 02.10.2017.
 */
@Module public class DataModule {

  @Provides RestApi provideRestApi() {
    return new RestApi();
  }

  @Provides DataManager provideDataManager(RestApi restApi) {
    return new DataManager(restApi);
  }

  @Provides String provideTestMessage() {
    return new String("test message");
  }
}
