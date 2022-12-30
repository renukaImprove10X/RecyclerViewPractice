package com.improve10x.recyclerviewpractice.filmDiary.series;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.SeriesItemBinding;

public class SeriesViewHolder extends RecyclerView.ViewHolder {
    protected SeriesItemBinding binding;

    public SeriesViewHolder(SeriesItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
