package com.yt.shorts.adapter;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yt.shorts.databinding.RowShortsBinding;
import com.yt.shorts.model.ShortsItem;

import java.util.List;

public class ShortsAdapter extends RecyclerView.Adapter<ShortsAdapter.ShortsViewHolder> {

    private List<ShortsItem> shortsItems;
    private MediaController mediaController;
    private int currentlyPlayingPosition = 0;

    public ShortsAdapter(List<ShortsItem> shortsItems) {
        this.shortsItems = shortsItems;
    }

    @NonNull
    @Override
    public ShortsAdapter.ShortsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowShortsBinding binding = RowShortsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ShortsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShortsViewHolder holder, int position) {
        ShortsItem item = shortsItems.get(position);
        holder.bind(item, position);
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

            rowShortsBinding.getRoot().getContext();
            mediaController = new MediaController(rowShortsBinding.getRoot().getContext());
            mediaController.setAnchorView(rowShortsBinding.vvShorts);

            rowShortsBinding.vvShorts.setOnClickListener(v -> {
                if (rowShortsBinding.vvShorts.isPlaying()) {
                    rowShortsBinding.vvShorts.pause();
                } else {
                    rowShortsBinding.vvShorts.start();
                }
            });
        }

        void bind(ShortsItem item, int position) {

            Uri uri = Uri.parse(item.getUrl());
            rowShortsBinding.vvShorts.setVideoURI(uri);

            if (currentlyPlayingPosition == position + 1) {
                rowShortsBinding.vvShorts.start(); // 현재 아이템이면 재생 시작
                mediaController.show(); // 비디오 컨트롤러 표시
            } else {
                rowShortsBinding.vvShorts.pause(); // 아니면 정지
            }

            // 비디오 끝나면 다시 재생할 수 있도록 처리
            rowShortsBinding.vvShorts.setOnCompletionListener(mp -> {
                rowShortsBinding.vvShorts.seekTo(0); // 비디오를 처음으로 돌려놓고
                rowShortsBinding.vvShorts.pause(); // 일시 정지
            });

            itemView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View view) {
                    rowShortsBinding.vvShorts.start();
                }

                @Override
                public void onViewDetachedFromWindow(View view) {
                        rowShortsBinding.vvShorts.pause();

                }
            });

            // 클릭 이벤트 등을 설정하여 아이템 클릭 시 재생을 시작하도록 구현할 수도 있습니다.

            // 기타 필요한 데이터 바인딩
            rowShortsBinding.tvMediaTitle.setText(item.getTitle());
            rowShortsBinding.tvUserName.setText("이름");
        }

    }

}
