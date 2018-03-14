package com.example.dimuch.companion.feature.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.base.BaseActivity;
import com.example.dimuch.companion.feature.activities.MainActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import timber.log.Timber;

public class SplashActivity extends BaseActivity implements ISplashActivityView {
  @InjectPresenter SplashActivityPresenter mPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_splash);
    super.onCreate(savedInstanceState);

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    //myRef.setValue("Hello, World!");
    //Timber.e("sotore " + database.getReference().child("message").ge));m
   myRef.child("message").addChildEventListener(new ChildEventListener() {
     @Override public void onChildAdded(DataSnapshot dataSnapshot, String s) {
       Timber.e("sotore" + dataSnapshot.getValue(String.class));
     }

     @Override public void onChildChanged(DataSnapshot dataSnapshot, String s) {
       Timber.e("sotore" + dataSnapshot.getValue(String.class));

     }

     @Override public void onChildRemoved(DataSnapshot dataSnapshot) {

     }

     @Override public void onChildMoved(DataSnapshot dataSnapshot, String s) {

     }

     @Override public void onCancelled(DatabaseError databaseError) {

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
