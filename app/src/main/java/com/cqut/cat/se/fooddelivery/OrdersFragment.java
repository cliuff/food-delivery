package com.cqut.cat.se.fooddelivery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cqut.cat.se.fooddelivery.databinding.FragmentOrdersBinding;
import com.cqut.cat.se.fooddelivery.diy.GeneralActivity;
import com.cqut.cat.se.fooddelivery.diy.GeneralFragment;

public class OrdersFragment extends GeneralFragment implements MainActivity.MainPage {

    private FragmentOrdersBinding mViews;

    public static OrdersFragment newInstance() {
        return new OrdersFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViews = FragmentOrdersBinding.inflate(inflater, container, false);
        return mViews.getRoot();
    }

    @Override
    protected void consumeInsets(GeneralActivity.WindowInsets insets) {
        ViewGroup container = mViews.ordersContainer.findViewById(R.id.mainTopContainer);
        container.setPadding(container.getPaddingStart(), insets.top, container.getPaddingEnd(), container.getPaddingBottom());
    }

    @Override
    public void onPageVisible() {
    }

    @Override
    public void onVisiblyClick() {
    }
}
