package com.example.dimuch.companion.feature.profile;

import android.os.Bundle;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.base.BaseActivity;

public class ProfileActivity extends BaseActivity implements IProfileActivityView {

  @InjectPresenter ProfileActivityPresenter mPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public void setUpUI() {
    setContentView(R.layout.activity_profile);
    setTitle(R.string.profile);
  }
}
