package com.improve10x.recyclerviewpractice.grocery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GroceriesAdapter extends RecyclerView.Adapter<GroceriesViewHolder> {
    ArrayList<Grocery> groceries;
    @NonNull
    @Override
    public GroceriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.grocery_item, parent,false);
        GroceriesViewHolder groceriesViewHolder = new GroceriesViewHolder(view);
        return groceriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GroceriesViewHolder holder, int position) {
        Grocery grocery = groceries.get(position);
        Picasso.get().load(grocery.imageUrl).into(holder.groceryImg);
        holder.title.setText(grocery.name);
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
