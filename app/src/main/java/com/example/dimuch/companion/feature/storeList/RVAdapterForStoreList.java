package com.example.dimuch.companion.feature.storeList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.dimuch.companion.R;
import com.example.dimuch.companion.data.model.Store;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

public class RVAdapterForStoreList extends RecyclerView.Adapter<RVAdapterForStoreList.ViewHolder> {

  private List<Store> mStoreList;

  public RVAdapterForStoreList() {
    mStoreList = new ArrayList<>();
    Timber.d("adapter");
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvStore) TextView tvStore;
    @BindView(R.id.ivFavorite) ImageView ivFavorite;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    @OnClick(R.id.ivFavorite) public void onClickFavorite(){
      if (mStoreList.get(getLayoutPosition()).isFavorite())
        mStoreList.get(getLayoutPosition()).setFavorite(false);
      else
        mStoreList.get(getLayoutPosition()).setFavorite(true);

      notifyDataSetChanged();
    }
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
    View v = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_recycle_view_store, viewGroup, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.tvStore.setText(mStoreList.get(position).getName());
    if (mStoreList.get(position).isFavorite())
      holder.ivFavorite.setImageResource(R.mipmap.ic_star_true);
    else
      holder.ivFavorite.setImageResource(R.mipmap.ic_star_false);
  }

  @Override public int getItemCount() {
    return mStoreList.size();
  }

  @Override public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }

  public int getIdStore(int position) {
    return mStoreList.get(position).getId();
  }

  public void updateData(List<Store> viewModels) {
    mStoreList.clear();
    mStoreList.addAll(viewModels);
    notifyDataSetChanged();
  }
}