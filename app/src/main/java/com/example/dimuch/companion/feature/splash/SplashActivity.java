package com.example.dimuch.companion.feature.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.base.BaseActivity;
import com.example.dimuch.companion.data.model.ShoppingCenter;
import com.example.dimuch.companion.data.model.Store;
import com.example.dimuch.companion.feature.main.MainActivity;
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

    loadStoresList();
    loadProfile();
  }

  private void loadStoresList() {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    //myRef.setValue("Hello, World!");
    //Timber.e("sotore " + database.getReference().child("message").ge));m
    myRef.addValueEventListener(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {

        mPresenter.firebaseRepository.setShoppingCenter(
            dataSnapshot.child("ShoppingCenter").getValue(ShoppingCenter.class));

        Timber.wtf(dataSnapshot.child("ShoppingCenter").getValue(ShoppingCenter.class).toString());

        for (DataSnapshot ds : dataSnapshot.child("ShoppingCenter").child("stores").getChildren())
          Timber.e("store" + ds.getValue(Store.class));
      }

      @Override public void onCancelled(DatabaseError databaseError) {
        Timber.e("sotore" + databaseError.getMessage());
      }
    });
  }

  private void loadProfile() {

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

  //@Override public void moveToNextActivity() {
  //  Intent intent = new Intent(getApplicationContext(), GoogleLoginHiddenActivity.class);
  //  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
  //  intent.putExtra(GoogleLoginHiddenActivity.EXTRA_CLIENT_ID,
  //      "923835861335-safjg18e61qaaqlhnn37vo7ed06decdk.apps.googleusercontent.com");
  //  startActivity(intent);
  //}

  @Override public void moveToNextActivity() {
    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    startActivity(intent);
  }
}
