package com.example.dimuch.companion.feature.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.feature.views.IMenuActivityView;

public class MenuActivity extends AppCompatActivity implements IMenuActivityView{

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);
  }
}
