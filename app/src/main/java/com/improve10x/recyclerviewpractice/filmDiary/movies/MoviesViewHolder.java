package com.improve10x.recyclerviewpractice.filmDiary.movies;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.MovieItemBinding;

public class MoviesViewHolder extends RecyclerView.ViewHolder {
    protected MovieItemBinding binding;

    public MoviesViewHolder(MovieItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
