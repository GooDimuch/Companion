package com.example.dimuch.companion.feature.storeList;

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
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.data.model.Store;
import com.example.dimuch.companion.feature.store.StoreActivity;
import com.example.dimuch.companion.utils.ItemClickSupport;
import java.util.List;

/**
 * Created by Dimuch on 27.11.2017.
 */

public class StoreListActivity extends MvpAppCompatActivity implements IStoreListActivityView {

  @BindView(R.id.etSearch) EditText etSearch;
  @BindView(R.id.rvStoreList) RecyclerView rvStoreList;

  @InjectPresenter StoreListActivityPresenter mPresenter;
  private RVAdapterForStoreList rvAdapterForStoreList;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_store_list);
    ButterKnife.bind(this);
    setTitle(R.string.store_list);

    LinearLayoutManager layoutManagerForStores =
        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
    rvStoreList.setLayoutManager(layoutManagerForStores);
    rvAdapterForStoreList = new RVAdapterForStoreList();
    rvStoreList.setAdapter(rvAdapterForStoreList);

    ItemClickSupport.addTo(rvStoreList).setOnItemClickListener((recyclerView, position, v) -> {
      showToast("pos = " + position);

      Intent intent = new Intent(this, StoreActivity.class);
      //intent.putExtra("item_position", rvAdapterForStoreList.getIdStore(position));
      intent.putExtra("item_position", mPresenter.getCurrentStoreList().get(position).getId());
      startActivity(intent);
    });
  }

  @Override public void updateDataInList(List<Store> storeNameList) {
    rvAdapterForStoreList.updateData(storeNameList);
  }

  @Override public void showToast(String sToastMessage) {
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_SHORT).show();
  }

  @OnTextChanged(R.id.etSearch) public void etSearch(Editable s) {
    showToast(s + " butter");
    rvAdapterForStoreList.updateData(mPresenter.getListYouAreLookingFor(s.toString()));
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putString("etSearch", String.valueOf(etSearch.getText()));
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    etSearch.setText(savedInstanceState.getString("etSearch"));
  }
}
