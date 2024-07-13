package com.yt.shorts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;

import com.yt.shorts.adapter.ShortsAdapter;
import com.yt.shorts.databinding.ActivityMainBinding;
import com.yt.shorts.databinding.RowShortsBinding;
import com.yt.shorts.model.ShortsItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    RowShortsBinding rowShortsBinding;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rowShortsBinding = RowShortsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager = binding.vpShorts;
        ShortsAdapter shortsAdapter = new ShortsAdapter(getShortsData());
        viewPager.setAdapter(shortsAdapter);
    }

    private List<ShortsItem> getShortsData() {
        List<ShortsItem> items = new ArrayList<>();

        items.add(new ShortsItem("https://s3.ap-northeast-2.amazonaws.com/beaunex.net/22222.mp4", "title", "description"));
        items.add(new ShortsItem("https://s3.ap-northeast-2.amazonaws.com/beaunex.net/22222.mp4", "title", "description"));
        items.add(new ShortsItem("https://s3.ap-northeast-2.amazonaws.com/beaunex.net/22222.mp4", "title", "description"));
        items.add(new ShortsItem("https://s3.ap-northeast-2.amazonaws.com/beaunex.net/22222.mp4", "title", "description"));

        return items;
    }
}