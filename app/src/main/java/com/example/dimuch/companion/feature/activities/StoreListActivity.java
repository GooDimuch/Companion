package com.example.dimuch.companion.feature.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.feature.adapters.RVAdapterForStoreList;
import com.example.dimuch.companion.feature.views.IStoreListActivityView;
import com.example.dimuch.companion.utils.ItemClickSupport;
import com.example.dimuch.companion.utils.StoreListHelper;

/**
 * Created by Dimuch on 27.11.2017.
 */

public class StoreListActivity extends MvpAppCompatActivity implements IStoreListActivityView {

  @BindView(R.id.etSearch) EditText etSearch;
  @BindView(R.id.rvStoreList) RecyclerView rvStoreList;

  private StoreListHelper mStoreListHelper;
  private RVAdapterForStoreList rvAdapterForStoreList;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_store_list);
    ButterKnife.bind(this);
    setTitle(R.string.store_list);

    mStoreListHelper = new StoreListHelper();

    LinearLayoutManager layoutManagerForStores =
        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
    rvStoreList.setLayoutManager(layoutManagerForStores);
    rvAdapterForStoreList = new RVAdapterForStoreList(mStoreListHelper.getmStoreList());
    rvStoreList.setAdapter(rvAdapterForStoreList);

    ItemClickSupport.addTo(rvStoreList).setOnItemClickListener((recyclerView, position, v) -> {
      showToast("pos = " + position);

      Intent intent = new Intent(this, StoreActivity.class);
      intent.putExtra("item_position", rvAdapterForStoreList.getTVStore(position));
      startActivity(intent);
    });
  }

  @Override public void showToast(String sToastMessage) {
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_SHORT).show();
  }

  @OnTextChanged(R.id.etSearch) public void etSearch(Editable s) {
    showToast(s + " butter");
    rvAdapterForStoreList.updateData(mStoreListHelper.getListYouAreLookingFor(s.toString()));
  }
}
