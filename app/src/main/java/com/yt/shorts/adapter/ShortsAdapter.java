package com.yt.shorts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yt.shorts.R;
import com.yt.shorts.databinding.RowShortsBinding;
import com.yt.shorts.model.ShortsItem;

import java.util.List;

public class ShortsAdapter extends RecyclerView.Adapter<ShortsAdapter.ShortsViewHolder> {

    List<ShortsItem> shortsItems;

    public ShortsAdapter(List<ShortsItem> shortsItems) {
        this.shortsItems = shortsItems;
    }

    @NonNull
    @Override
    public ShortsAdapter.ShortsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shorts, parent, false);
        RowShortsBinding binding = RowShortsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ShortsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShortsViewHolder holder, int position) {
        ShortsItem item = shortsItems.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return shortsItems.size();
    }

    class ShortsViewHolder extends RecyclerView.ViewHolder {

        RowShortsBinding rowShortsBinding;

        public ShortsViewHolder(@NonNull RowShortsBinding rowShortsBinding) {
            super(rowShortsBinding.getRoot());
            this.rowShortsBinding = rowShortsBinding;
        }

        void bind(ShortsItem item) {
            rowShortsBinding.tvMediaTitle.setText(item.getTitle());
            rowShortsBinding.tvUserName.setText("이름");
        }

    }
}
