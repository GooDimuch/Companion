package com.example.dimuch.companion.feature.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.base.BaseActivity;
import com.example.dimuch.companion.data.model.Store;
import com.example.dimuch.companion.feature.activities.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import timber.log.Timber;

public class SplashActivity extends BaseActivity implements ISplashActivityView {
  @InjectPresenter SplashActivityPresenter mPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_splash);
    super.onCreate(savedInstanceState);

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    //myRef.setValue("Hello, World!");
    //Timber.e("sotore " + database.getReference().child("message").ge));m
    myRef.addValueEventListener(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
        Timber.e("sotore" + dataSnapshot.getChildrenCount());
        Timber.e("sotore" + dataSnapshot.getValue(true));
        //Timber.e("sotore" + dataSnapshot.getValue(Store.class).getAddressStore());
        Timber.e("sotore" + dataSnapshot.child("StoreList").child("store").getValue(Store.class).toString());r

      }

      @Override public void onCancelled(DatabaseError databaseError) {
        Timber.e("sotore" + databaseError.getMessage());
      }
    });
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
