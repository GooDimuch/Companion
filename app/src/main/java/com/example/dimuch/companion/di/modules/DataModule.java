package com.example.dimuch.companion.di.modules;

import com.example.dimuch.companion.data.DataManager;
import com.example.dimuch.companion.data.model.AllData;
import com.example.dimuch.companion.data.remote.RestApi;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Dimuch on 02.10.2017.
 */
@Module public class DataModule {

  @Provides AllData provideAllData() {
    return new AllData();
  }

  @Provides RestApi provideRestApi(AllData allData) {
    return new RestApi(allData);
  }

  @Provides DataManager provideDataManager(RestApi restApi) {
    return new DataManager(restApi);
  }

  @Provides String provideTestMessage() {
    return new String("test message");
  }
}
