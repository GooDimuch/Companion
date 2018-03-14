package com.example.dimuch.companion.base;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;

/**
 * Created by vrungel on 14.03.2018.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);
    setUpUI();
  }

  public abstract void setUpUI();

  protected void showToastMessage(String message) {
    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
  }

  protected void showToastMessage(@StringRes int id) {
    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
  }
}