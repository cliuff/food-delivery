package com.cqut.cat.se.fooddelivery;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.cqut.cat.se.fooddelivery.databinding.ActivityLoginBinding;
import com.cqut.cat.se.fooddelivery.diy.GeneralActivity;

public class LoginActivity extends GeneralActivity {

    private ActivityLoginBinding mViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViews = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mViews.getRoot());
    }

    @Override
    protected void consumeInsets(WindowInsets insets) {
    }
}
