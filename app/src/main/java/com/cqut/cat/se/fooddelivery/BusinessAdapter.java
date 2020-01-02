package com.cqut.cat.se.fooddelivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.cqut.cat.se.fooddelivery.databinding.AdapterBusinessBinding;
import com.cqut.cat.se.fooddelivery.entity.Business;

import java.util.ArrayList;
import java.util.List;

public class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.BusinessHolder> {

    static class BusinessHolder extends RecyclerView.ViewHolder {

        AppCompatTextView name;
        AppCompatTextView timeConsumption;
        AppCompatTextView monthlySales;
        AppCompatTextView rating;

        BusinessHolder(AdapterBusinessBinding binding) {
            super(binding.getRoot());
            name = (AppCompatTextView) binding.adapterBusinessName;
            timeConsumption = (AppCompatTextView) binding.adapterBusinessTimeConsumption;
            monthlySales = (AppCompatTextView) binding.adapterBusinessMonthlySales;
            rating = (AppCompatTextView) binding.adapterBusinessRating;
        }
    }

    private LayoutInflater mLayoutInflater;
    private List<Business> businesses;

    public BusinessAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        businesses = new ArrayList<>(0);
    }

    public void setOrders(List<Business> businesses) {
        this.businesses = businesses;
    }

    @NonNull
    @Override
    public BusinessHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BusinessHolder(AdapterBusinessBinding.inflate(mLayoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessHolder holder, int position) {
        Business business = businesses.get(position);
        holder.name.setText(business.getName());
        holder.monthlySales.setText("月售 " + business.getMonthlySales());
        holder.timeConsumption.setText(business.getTimeConsumption() + " min");
        holder.rating.setText(String.valueOf(business.getRating()));
    }

    @Override
    public int getItemCount() {
        return businesses.size();
    }
}
