package com.example.dimuch.companion.feature.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.base.BaseActivity;
import com.example.dimuch.companion.data.model.ShoppingCenter;
import com.example.dimuch.companion.feature.googleLogin.GoogleLoginHiddenActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.IARegion;
import com.indooratlas.android.sdk.resources.IAFloorPlan;
import com.indooratlas.android.sdk.resources.IAResourceManager;
import com.indooratlas.android.sdk.resources.IATask;
import com.squareup.picasso.Picasso;
import timber.log.Timber;

public class SplashActivity extends BaseActivity implements ISplashActivityView {
  @InjectPresenter SplashActivityPresenter mPresenter;
  @BindView(R.id.ivPlan) ImageView ivPlan;
  private IALocationManager mIALocationManager;
  private IAResourceManager mIAResourceManager = new IAResourceManager() {
    @Override public IATask<IAFloorPlan> fetchFloorPlanWithId(@NonNull String s) {
      fetchFloorPlan(s);
      return null;
    }
  };
  private IALocationListener mIALocationListener = new IALocationListener() {

    // Called when the location has changed.
    @Override public void onLocationChanged(IALocation location) {

      Timber.e("Latitude: " + location.getLatitude());
      Timber.e("Longitude: " + location.getLongitude());
      Timber.e("Floor number: " + location.getFloorLevel());
    }

    @Override public void onStatusChanged(String s, int i, Bundle bundle) {

    }
  };

  private IARegion.Listener mRegionListener = new IARegion.Listener() {
    // when null, we are not on any mapped area
    // this information can be used for indoor-outdoor detection
    IARegion mCurrentFloorPlan = null;

    @Override public void onEnterRegion(IARegion region) {
      if (region.getType() == IARegion.TYPE_FLOOR_PLAN) {
        fetchFloorPlan(region.getId());
        // triggered when entering the mapped area of the given floor plan
        Timber.e("Entered " + region.getName());
        Timber.e("floor plan ID: " + region.getId());
        mCurrentFloorPlan = region;
      } else if (region.getType() == IARegion.TYPE_VENUE) {
        // triggered when near a new location
        Timber.e("Location changed to " + region.getId());
      }
    }

    @Override public void onExitRegion(IARegion region) {
      // leaving a previously entered region
      if (region.getType() == IARegion.TYPE_FLOOR_PLAN) {
        mCurrentFloorPlan = null;
        // notice that a change of floor plan (e.g., floor change)
        // is signaled by an exit-enter pair so ending up here
        // does not yet mean that the device is outside any mapped area
      }
    }
  };
  private IATask<IAFloorPlan> mPendingAsyncResult;

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_splash);
    super.onCreate(savedInstanceState);

    mIALocationManager = IALocationManager.create(this);

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

        //Timber.wtf(dataSnapshot.child("ShoppingCenter").getValue(ShoppingCenter.class).toString());

        for (DataSnapshot ds : dataSnapshot.child("ShoppingCenter").child("stores").getChildren()) {
        }
        //Timber.e("store" + ds.getValue(Store.class));
      }

      @Override public void onCancelled(DatabaseError databaseError) {
        //Timber.e("sotore" + databaseError.getMessage());
      }
    });
  }

  @Override protected void onResume() {
    super.onResume();
    mIALocationManager.requestLocationUpdates(IALocationRequest.create(), mIALocationListener);
    mIALocationManager.registerRegionListener(mRegionListener);
  }

  private void fetchFloorPlan(String id) {
    // Cancel pending operation, if any
    if (mPendingAsyncResult != null && !mPendingAsyncResult.isCancelled()) {
      mPendingAsyncResult.cancel();
    }

    mPendingAsyncResult = mIAResourceManager.fetchFloorPlanWithId(id);
    if (mPendingAsyncResult != null) {
      mPendingAsyncResult.setCallback(result -> {
        Timber.e("onResult: " + result);

        if (result.isSuccess()) {
          handleFloorPlanChange(result.getResult());
        } else {
          // do something with error
          Toast.makeText(SplashActivity.this, "loading floor plan failed: " + result.getError(),
              Toast.LENGTH_LONG).show();
        }
      }, Looper.getMainLooper()); // deliver callbacks in main thread
    }
  }

  private void handleFloorPlanChange(IAFloorPlan newFloorPlan) {
    Picasso.get().load(newFloorPlan.getUrl()).into(ivPlan);
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

  @Override public void moveToNextActivity() {
    //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    //startActivity(intent);
    Intent intent = new Intent(getApplicationContext(), GoogleLoginHiddenActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.putExtra(GoogleLoginHiddenActivity.EXTRA_CLIENT_ID,
        "923835861335-safjg18e61qaaqlhnn37vo7ed06decdk.apps.googleusercontent.com");

    startActivity(intent);
  }
}
