package com.cqut.cat.se.fooddelivery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cqut.cat.se.fooddelivery.databinding.FragmentHomeBinding;
import com.cqut.cat.se.fooddelivery.diy.GeneralActivity;
import com.cqut.cat.se.fooddelivery.diy.GeneralFragment;
import com.cqut.cat.se.fooddelivery.entity.Business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeFragment extends GeneralFragment implements MainActivity.MainPage {

    private FragmentHomeBinding mViews;
    private RecyclerView mRecyclerView;

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
        ViewGroup container = mViews.homeContainer.findViewById(R.id.mainTopContainer);
        container.setPadding(container.getPaddingStart(), insets.top, container.getPaddingEnd(), container.getPaddingBottom());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = mViews.homeRecyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        BusinessAdapter mAdapter = new BusinessAdapter(getContext());
        mAdapter.setOrders(fakeBusinesses());
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<Business> fakeBusinesses() {
        int count = 24;
        List<Business> businesses = new ArrayList<>(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Business business = new Business();
            business.setName("店铺 " + (i + 1));
            business.setTimeConsumption(random.nextInt(40) + 1);
            business.setRating(new BigDecimal(random.nextFloat() * 3 + 2).setScale(1, BigDecimal.ROUND_HALF_UP).floatValue());
            business.setMonthlySales(Math.round(business.getRating() * 400));
            businesses.add(business);
        }
        return businesses;
    }

    @Override
    public void onPageVisible() {
    }

    @Override
    public void onVisiblyClick() {
    }
}
