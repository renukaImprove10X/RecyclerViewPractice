package com.improve10x.recyclerviewpractice.filmDiary.series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.SeriesItemBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesViewHolder> {
    public List<Series> series;

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SeriesItemBinding binding = SeriesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        SeriesViewHolder seriesViewHolder = new SeriesViewHolder(binding);
        return seriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {
        Series series = this.series.get(position);
        holder.binding.titleTxt.setText(series.title);
        Picasso.get().load(series.imageUrl).into(holder.binding.seriesImg);
    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    public void setData(List<Series> series) {
        this.series = series;
        notifyDataSetChanged();
    }
}
