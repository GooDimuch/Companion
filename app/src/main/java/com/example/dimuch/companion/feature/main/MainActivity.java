package com.example.dimuch.companion.feature.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.feature.map.MapActivity;
import com.example.dimuch.companion.feature.profile.ProfileActivity;
import com.example.dimuch.companion.feature.storeList.StoreListActivity;

public class MainActivity extends MvpAppCompatActivity implements IMainActivityView {

  @BindView(R.id.bMap) Button bMap;
  @BindView(R.id.bStoreList) Button bStoreList;
  @BindView(R.id.bForFuture) Button bForFuture;

  @InjectPresenter MainActivityPresenter mainActivityPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.bMap) public void bMapClick(View view) {
    showToast("bMap");

    Intent intent = new Intent(this, MapActivity.class);
    startActivity(intent);
    overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
  }

  @OnClick(R.id.bStoreList) public void bStoreListClick(View view) {
    showToast("bStoreList");

    Intent intent = new Intent(this, StoreListActivity.class);
    startActivity(intent);
    overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
  }

  @OnClick(R.id.bForFuture) public void bForFutureClick(View view) {
    showToast("bForFuture");

    Intent intent = new Intent(this, ProfileActivity.class);
    startActivity(intent);
    overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);

  }

  @Override public void showToast(String sToastMessage) {
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_SHORT).show();
  }
}
