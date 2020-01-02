package com.cqut.cat.se.fooddelivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.cqut.cat.se.fooddelivery.databinding.AdapterOrderBinding;
import com.cqut.cat.se.fooddelivery.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {

    static class OrderHolder extends RecyclerView.ViewHolder {

        AppCompatTextView title;
        AppCompatTextView time;
        AppCompatTextView price;

        OrderHolder(AdapterOrderBinding binding) {
            super(binding.getRoot());
            title = (AppCompatTextView) binding.adapterOrderTitle;
            time = (AppCompatTextView) binding.adapterOrderTime;
            price = (AppCompatTextView) binding.adapterOrderPrice;
        }
    }

    private LayoutInflater mLayoutInflater;
    private List<Order> orders;

    public OrderAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        orders = new ArrayList<>(0);
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderHolder(AdapterOrderBinding.inflate(mLayoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        Order order = orders.get(position);
        holder.title.setText(order.getTitle());
        holder.time.setText(order.getTime());
        holder.price.setText("¥ " + order.getPrice());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}
