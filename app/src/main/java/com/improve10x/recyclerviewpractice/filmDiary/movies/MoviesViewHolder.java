package com.improve10x.recyclerviewpractice.filmDiary.movies;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;

public class MoviesViewHolder extends RecyclerView.ViewHolder {
    public ImageView movieImg;
    public TextView titleTxt;

    public MoviesViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTxt = itemView.findViewById(R.id.title_txt);
        movieImg = itemView.findViewById(R.id.grocery_img);
    }
}
