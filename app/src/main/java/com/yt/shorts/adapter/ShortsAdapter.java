package com.yt.shorts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yt.shorts.R;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shorts, parent, false);
        return new ShortsViewHolder(view);
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

        TextView titleTextView;

        public ShortsViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind(ShortsItem item) {
            titleTextView.setText(item.getTitle());
        }

    }
}
