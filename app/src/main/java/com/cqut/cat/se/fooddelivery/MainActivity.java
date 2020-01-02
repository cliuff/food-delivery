package com.cqut.cat.se.fooddelivery;

import android.os.Bundle;

import com.cqut.cat.se.fooddelivery.databinding.ActivityMainBinding;
import com.cqut.cat.se.fooddelivery.diy.GeneralActivity;

public class MainActivity extends GeneralActivity {

    private ActivityMainBinding mViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViews = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mViews.getRoot());
    }

    @Override
    protected void consumeInsets(GeneralActivity.WindowInsets insets) {
    }
}
