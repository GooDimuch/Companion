package com.example.dimuch.companion.feature.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.feature.adapters.RVAdapterForStoreList;
import com.example.dimuch.companion.feature.views.IStoreListActivityView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimuch on 27.11.2017.
 */

public class StoreListActivity extends MvpAppCompatActivity implements IStoreListActivityView {

  @BindView(R.id.etSearch) EditText etSearch;
  @BindView(R.id.rvStoreList) RecyclerView rvStoreList;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_store_list);
    ButterKnife.bind(this);
    setTitle(R.string.store_list);

    LinearLayoutManager layoutManagerForStores =
        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
    rvStoreList.setLayoutManager(layoutManagerForStores);
    RVAdapterForStoreList rvAdapterForStoreList = new RVAdapterForStoreList(testListForRV());
    rvStoreList.setAdapter(rvAdapterForStoreList);
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

  @Override public void showToast(String sToastMessage) {
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_SHORT).show();
  }
}
