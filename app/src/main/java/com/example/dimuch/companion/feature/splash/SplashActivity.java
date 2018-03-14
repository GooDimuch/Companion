package com.example.dimuch.companion.feature.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.base.BaseActivity;
import com.example.dimuch.companion.feature.activities.MainActivity;

public class SplashActivity extends BaseActivity implements ISplashActivityView {
  @InjectPresenter SplashActivityPresenter mPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_splash);
    super.onCreate(savedInstanceState);
  }

  @Override public void setUpUI() {
    hide();
  }

  private void hide() {
    // Hide UI first
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.hide();
    }
  }

  @Override public void moveToNextActivity() {
    startActivity(new Intent(getApplicationContext(), MainActivity.class));
  }
}
