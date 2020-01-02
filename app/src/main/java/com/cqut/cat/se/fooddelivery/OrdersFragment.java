package com.cqut.cat.se.fooddelivery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cqut.cat.se.fooddelivery.databinding.FragmentOrdersBinding;
import com.cqut.cat.se.fooddelivery.diy.GeneralActivity;
import com.cqut.cat.se.fooddelivery.diy.GeneralFragment;
import com.cqut.cat.se.fooddelivery.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrdersFragment extends GeneralFragment implements MainActivity.MainPage {

    private FragmentOrdersBinding mViews;
    private RecyclerView mRecyclerView;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = mViews.ordersRecyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        OrderAdapter mAdapter = new OrderAdapter(getContext());
        mAdapter.setOrders(fakeOrders());
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<Order> fakeOrders() {
        int count = 24;
        List<Order> orders = new ArrayList<>(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Order order = new Order();
            order.setTitle("订单 " + (i + 1));
            order.setTime("2019.12." + (random.nextInt(30) + 1));
            order.setPrice(random.nextInt(50));
            orders.add(order);
        }
        return orders;
    }

    @Override
    public void onPageVisible() {
    }

    @Override
    public void onVisiblyClick() {
    }
}
