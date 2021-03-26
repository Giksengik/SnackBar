package com.ru.snackbar.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ru.snackbar.R;
import com.ru.snackbar.models.products.IProduct;

import java.util.ArrayList;
import java.util.List;

public class BuyAdapter extends RecyclerView.Adapter<BuyAdapter.ViewHolder> {
    List<IProduct> products = new ArrayList<>();
    @NonNull
    @Override
    public BuyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.buy_in_list, parent, false);
        return new ViewHolder(itemView);
    }
    public BuyAdapter() {
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BuyAdapter.ViewHolder holder, int position) {
        IProduct product = products.get(position);
        holder.productCost.setText(product.getCost() + "");
        holder.productName.setText(product.getName());

    }
    public void setProducts(List<IProduct> products) {
        this.products = products;
    }
    @Override
    public int getItemCount() {
        return products.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView productName, productCost;
        ViewHolder(View v){
            super(v);
            productName = v.findViewById(R.id.productName);
            productCost = v.findViewById(R.id.productCost);
        }
    }
}
