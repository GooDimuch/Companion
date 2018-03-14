package com.example.dimuch.companion.base;

import android.content.Context;
import android.support.annotation.NonNull;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import com.example.dimuch.companion.data.DataManager;
import javax.inject.Inject;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by vrungel on 14.03.2018.
 */

public abstract class BasePresenter<V extends MvpView> extends MvpPresenter<V> {

  //@Inject protected RxBus mRxBus;
  @Inject protected DataManager mDataManager;
  @Inject protected Context mContext;

  private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

  public BasePresenter() {
    inject();
  }

  protected void addToUnsubscription(@NonNull Subscription subscription) {
    mCompositeSubscription.add(subscription);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    mCompositeSubscription.clear();
  }

  protected abstract void inject();
}
