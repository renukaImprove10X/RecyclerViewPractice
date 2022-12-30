package com.improve10x.recyclerviewpractice.grocery;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.GroceryItemBinding;

import org.w3c.dom.Text;

public class GroceriesViewHolder extends RecyclerView.ViewHolder {
    protected GroceryItemBinding binding;
    public GroceriesViewHolder(GroceryItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
