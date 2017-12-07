package com.example.dimuch.companion.feature.activities;

import android.os.Bundle;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.feature.views.IStoreActivityView;

/**
 * Created by Dimuch on 27.11.2017.
 */

public class StoreActivity extends MvpAppCompatActivity implements IStoreActivityView {


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map);
    ButterKnife.bind(this);
    setTitle(getIntent().getStringExtra("item_position"));
  }

  @Override public void showToast(String sToastMessage) {
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_SHORT).show();
  }
}
