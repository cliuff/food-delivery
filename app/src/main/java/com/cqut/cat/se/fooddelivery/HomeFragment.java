package com.cqut.cat.se.fooddelivery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.cqut.cat.se.fooddelivery.databinding.FragmentHomeBinding;
import com.cqut.cat.se.fooddelivery.diy.GeneralActivity;
import com.cqut.cat.se.fooddelivery.diy.GeneralFragment;

public class HomeFragment extends GeneralFragment implements MainActivity.MainPage {

    private FragmentHomeBinding mViews;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViews = FragmentHomeBinding.inflate(inflater, container, false);
        return mViews.getRoot();
    }

    @Override
    protected void consumeInsets(GeneralActivity.WindowInsets insets) {
    }

    @Override
    public void onPageVisible(Toolbar toolbar) {
    }

    @Override
    public void onVisiblyClick() {
    }
}
