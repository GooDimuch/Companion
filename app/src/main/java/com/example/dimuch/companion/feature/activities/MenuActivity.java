package com.example.dimuch.companion.feature.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.feature.views.IMenuActivityView;

public class MenuActivity extends MvpAppCompatActivity implements IMenuActivityView {

  @BindView(R.id.bMap) Button bMap;
  @BindView(R.id.bStoreList) Button bStoreList;
  @BindView(R.id.bForFuture) Button bForFuture;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.bMap) public void bMapClick(View view) {
    showToast("bMap");

    Intent intent = new Intent(this, MapActivity.class);
    startActivity(intent);
  }

  @OnClick(R.id.bStoreList) public void bStoreListClick(View view) {
    showToast("bStoreList");
    // TODO opens activity_store_list ...
  }

  @OnClick(R.id.bForFuture) public void bForFutureClick(View view) {
    showToast("bForFuture");
    // TODO opens activity_for_future ...
  }

  @Override public void showToast(String sToastMessage) {
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_SHORT).show();
  }
}
