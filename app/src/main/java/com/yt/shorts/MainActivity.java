package com.yt.shorts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.yt.shorts.adapter.ShortsAdapter;
import com.yt.shorts.databinding.ActivityMainBinding;
import com.yt.shorts.model.ShortsItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager = binding.vpShorts;
        ShortsAdapter shortsAdapter = new ShortsAdapter(getShortsData());
        viewPager.setAdapter(shortsAdapter);
    }

    private List<ShortsItem> getShortsData() {
        List<ShortsItem> items = new ArrayList<>();

        // 데이터를 추가해야함
        items.add(new ShortsItem("url", "title", "description"));
        return items;
    }
}