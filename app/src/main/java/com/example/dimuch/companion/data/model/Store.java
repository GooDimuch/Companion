package com.example.dimuch.companion.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dimuch on 07.12.2017.
 */

public class Store {

  private int mLogoStore;
  @SerializedName("name") private String name;
  @SerializedName("rating") private double mRatingStore;
  @SerializedName("type") private String mTypeStore;
  private String mAddressStore;
  @SerializedName("website") private String mWebSiteStore;
  private String mPhoneStore;
  @SerializedName("workSchedule") private String mWorkScheduleStore;

  public Store() {
  }

  public Store(int logoStore, String nameStore, double ratingStore, String typeStore,
      String addressStore, String webSiteStore, String phoneStore, String workScheduleStore) {
    this.mLogoStore = logoStore;
    this.name = nameStore;
    this.mRatingStore = ratingStore;
    this.mTypeStore = typeStore;
    this.mAddressStore = addressStore;
    this.mWebSiteStore = webSiteStore;
    this.mPhoneStore = phoneStore;
    this.mWorkScheduleStore = workScheduleStore;
  }

  public Store(String nameStore) {
    this.name = nameStore;
  }

  public int getLogoStore() {
    return mLogoStore;
  }

  public void setLogoStore(int mLogoStore) {
    this.mLogoStore = mLogoStore;
  }

  public String getNameStore() {
    return name;
  }

  public void setNameStore(String name) {
    this.name = name;
  }

  public float getRatingStore() {
    return (float) mRatingStore;
  }

  public void setRatingStore(double mRatingStore) {
    this.mRatingStore = mRatingStore;
  }

  public String getTypeStore() {
    return mTypeStore;
  }

  public void setTypeStore(String mTypeStore) {
    this.mTypeStore = mTypeStore;
  }

  public String getAddressStore() {
    return mAddressStore;
  }

  public void setAddressStore(String mAddressStore) {
    this.mAddressStore = mAddressStore;
  }

  public String getWebSiteStore() {
    return mWebSiteStore;
  }

  public void setWebSiteStore(String mWebSiteStore) {
    this.mWebSiteStore = mWebSiteStore;
  }

  public String getPhoneStore() {
    return mPhoneStore;
  }

  public void setPhoneStore(String mPhoneStore) {
    this.mPhoneStore = mPhoneStore;
  }

  public String getWorkScheduleStore() {
    return mWorkScheduleStore;
  }

  public void setWorkScheduleStore(String mWorkScheduleStore) {
    this.mWorkScheduleStore = mWorkScheduleStore;
  }
}
