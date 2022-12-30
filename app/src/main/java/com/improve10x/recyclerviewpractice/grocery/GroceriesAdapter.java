package com.improve10x.recyclerviewpractice.grocery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.GroceryItemBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GroceriesAdapter extends RecyclerView.Adapter<GroceriesViewHolder> {
    ArrayList<Grocery> groceries;
    @NonNull
    @Override
    public GroceriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GroceryItemBinding binding = GroceryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        GroceriesViewHolder groceriesViewHolder = new GroceriesViewHolder(binding);
        return groceriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GroceriesViewHolder holder, int position) {
        Grocery grocery = groceries.get(position);
        Picasso.get().load(grocery.imageUrl).into(holder.binding.groceryImg);
        holder.binding.titleTxt.setText(grocery.name);
    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }

    public void setData(ArrayList<Grocery> groceries) {
        this.groceries = groceries;
        notifyDataSetChanged();
    }
}
