package com.cqut.cat.se.fooddelivery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.cqut.cat.se.fooddelivery.databinding.FragmentMoreBinding;
import com.cqut.cat.se.fooddelivery.diy.GeneralActivity;
import com.cqut.cat.se.fooddelivery.diy.GeneralFragment;

public class MoreFragment extends GeneralFragment implements MainActivity.MainPage {

    private FragmentMoreBinding mViews;

    public static MoreFragment newInstance() {
        return new MoreFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViews = FragmentMoreBinding.inflate(inflater, container, false);
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
