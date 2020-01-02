package com.cqut.cat.se.fooddelivery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cqut.cat.se.fooddelivery.databinding.FragmentExploreBinding;
import com.cqut.cat.se.fooddelivery.diy.GeneralActivity;
import com.cqut.cat.se.fooddelivery.diy.GeneralFragment;

public class ExploreFragment extends GeneralFragment implements MainActivity.MainPage {

    private FragmentExploreBinding mViews;

    public static ExploreFragment getInstance() {
        return new ExploreFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViews = FragmentExploreBinding.inflate(inflater, container, false);
        return mViews.getRoot();
    }

    @Override
    protected void consumeInsets(GeneralActivity.WindowInsets insets) {
        ViewGroup container = mViews.exploreContainer.findViewById(R.id.mainTopContainer);
        container.setPadding(container.getPaddingStart(), insets.top, container.getPaddingEnd(), container.getPaddingBottom());
    }

    @Override
    public void onPageVisible() {
    }

    @Override
    public void onVisiblyClick() {
    }
}
