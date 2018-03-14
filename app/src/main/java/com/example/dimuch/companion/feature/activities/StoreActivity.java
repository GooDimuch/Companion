package com.example.dimuch.companion.feature.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.data.model.Store;
import com.example.dimuch.companion.feature.presenters.StoreActivityPresenter;
import com.example.dimuch.companion.feature.views.IStoreActivityView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StoreActivity extends AppCompatActivity implements IStoreActivityView {

  @BindView(R.id.fab) FloatingActionButton fab;
  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.toolbar_layout) CollapsingToolbarLayout toolbar_layout;
  @BindView(R.id.rbRatingStore) RatingBar rbRatingStore;
  @BindView(R.id.tvNameStore) TextView tvNameStore;
  @BindView(R.id.tvRatingStore) TextView tvRatingStore;
  @BindView(R.id.tvTypeStore) TextView tvTypeStore;
  @BindView(R.id.tvAddress) TextView tvAddress;
  @BindView(R.id.tvWebSite) TextView tvWebSite;
  @BindView(R.id.tvPhone) TextView tvPhone;
  @BindView(R.id.tvWorkSchedule) TextView tvWorkSchedule;

  @InjectPresenter StoreActivityPresenter storeActivityPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_store);
    ButterKnife.bind(this);
    setSupportActionBar(toolbar);

    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();


    Store tempStore =
        new Store(R.drawable.store, getIntent().getStringExtra("item_position"), 7 / 2.0,
            "Магазин электроники", "вулиця Ярославська, 57, Київ, 02000", "rozetka.com.ua",
            "044 503 8080", "Открыто:  10–21\n"
        + "понедельник\t10–21\n"
        + "вторник\t10–21\n"
        + "среда\t10–21\n"
        + "четверг\t10–21\n"
        + "пятница\t10–21\n"
        + "суббота\t10–21\n"
        + "воскресенье\t10–18\n");

    setLogoStore(tempStore.getLogoStore());
    setNameStore(tempStore.getNameStore());
    setRatingStore(tempStore.getRatingStore());
    setTypeStore(tempStore.getTypeStore());
    setAddressStore(tempStore.getAddressStore());
    setWebSiteStore(tempStore.getWebSiteStore());
    setPhoneStore(tempStore.getPhoneStore());
    setWorkScheduleStore(tempStore.getWorkScheduleStore());
  }

  @OnClick(R.id.fab) public void onClickFab(View view) {
    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null)
        .show();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_store, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override public void showToast(String sToastMessage) {
    Toast.makeText(getApplicationContext(), sToastMessage, Toast.LENGTH_SHORT).show();
  }

  @Override public void setLogoStore(int iLogoStore) {
    toolbar_layout.setBackground(getResources().getDrawable(iLogoStore));
  }

  @Override public void setNameStore(String sNameStore) {
    setTitle(sNameStore);
    tvNameStore.setText(sNameStore);
  }

  @Override public void setRatingStore(float fRatingStore) {
    tvRatingStore.setText(String.valueOf(fRatingStore));
    rbRatingStore.setRating(fRatingStore);
  }

  @Override public void setTypeStore(String sTypeStore) {
    tvTypeStore.setText(sTypeStore);
  }

  @Override public void setAddressStore(String sAddressStore) {
    tvAddress.setText(sAddressStore);
  }

  @Override public void setWebSiteStore(String sWebSiteStore) {
    tvWebSite.setText(sWebSiteStore);
  }

  @Override public void setPhoneStore(String sPhoneStore) {
    tvPhone.setText(sPhoneStore);
  }

  @Override public void setWorkScheduleStore(String sWorkScheduleStore) {
    tvWorkSchedule.setText(sWorkScheduleStore);
  }
}
