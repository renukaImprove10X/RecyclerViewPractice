package com.improve10x.recyclerviewpractice.grocery;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;

import org.w3c.dom.Text;

public class GroceriesViewHolder extends RecyclerView.ViewHolder {
    ImageView groceryImg;
    TextView title;
    public GroceriesViewHolder(@NonNull View itemView) {
        super(itemView);
        groceryImg = itemView.findViewById(R.id.grocery_img);
        title = itemView.findViewById(R.id.title_txt);
    }
}
