package com.example.dimuch.companion.data.model;

/**
 * Created by Dimuch on 07.12.2017.
 */

public class Store {

  private int mIdStore;
  private int mLogoStore;
  private String mNameStore;
  private double mRatingStore;
  private String mTypeStore;
  private String mAddressStore;
  private String mWebSiteStore;
  private String mPhoneStore;
  private String mWorkScheduleStore;

  public Store() {
  }

  public Store(int idStore, int logoStore, String nameStore, double ratingStore, String typeStore,
      String addressStore, String webSiteStore, String phoneStore, String workScheduleStore) {
    this.mIdStore = idStore;
    this.mLogoStore = logoStore;
    this.mNameStore = nameStore;
    this.mRatingStore = ratingStore;
    this.mTypeStore = typeStore;
    this.mAddressStore = addressStore;
    this.mWebSiteStore = webSiteStore;
    this.mPhoneStore = phoneStore;
    this.mWorkScheduleStore = workScheduleStore;
  }

  public int getId() {
    return mIdStore;
  }

  public void setId(int mId) {
    this.mIdStore = mId;
  }

  public int getLogoStore() {
    return mLogoStore;
  }

  public void setLogoStore(int mLogoStore) {
    this.mLogoStore = mLogoStore;
  }

  public String getNameStore() {
    return mNameStore;
  }

  public void setNameStore(String mNameStore) {
    this.mNameStore = mNameStore;
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

  @Override public String toString() {
    return getNameStore();
  }
}
