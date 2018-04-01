package com.example.dimuch.companion.feature.profile;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.base.BaseActivity;
import com.example.dimuch.companion.data.model.Profile;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends BaseActivity implements IProfileActivityView {
  @BindView(R.id.ivProfilePhoto) ImageView ivProfilePhoto;
  @BindView(R.id.tvName) TextView tvName;
  @BindView(R.id.tvTemp) TextView tvTemp;
  @BindView(R.id.tvTemp2) TextView tvTemp2;

  @InjectPresenter ProfileActivityPresenter mPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public void setUpUI() {
    setContentView(R.layout.activity_profile);
    setTitle(R.string.profile);
  }

  @Override public void updateProfile(Profile profile) {

    Picasso.get()
        .load(profile.getPhotoUrl())
        .fit()
        .placeholder(R.mipmap.ic_launcher_round)
        .into(ivProfilePhoto);

    tvName.setText(profile.getName());
    tvTemp.setText(profile.getEmail());
    tvTemp2.setText(profile.getPageLink());
  }
}
