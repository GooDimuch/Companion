package com.example.dimuch.companion.feature.map;

import android.os.Bundle;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.companion.R;

/**
 * Created by Dimuch on 27.11.2017.
 */

public class MapActivity extends MvpAppCompatActivity implements IMapActivityView {


  @InjectPresenter MapActivityPresenter mapActivityPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map);
    ButterKnife.bind(this);
    setTitle(R.string.map);
  }

  @Override public void showToast(String sToastMessage) {
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_SHORT).show();
  }
}
