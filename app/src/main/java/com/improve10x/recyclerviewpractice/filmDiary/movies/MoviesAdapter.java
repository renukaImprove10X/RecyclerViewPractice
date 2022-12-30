package com.improve10x.recyclerviewpractice.filmDiary.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.MovieItemBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {
    public List<Movie> movies;

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemBinding binding = MovieItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        MoviesViewHolder moviesViewHolder = new MoviesViewHolder(binding);
        return moviesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        Movie movie = this.movies.get(position);
        holder.binding.titleTxt.setText(movie.title);
        Picasso.get().load(movie.imageUrl).into(holder.binding.movieImg);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setData(List<Movie> series) {
        this.movies = series;
        notifyDataSetChanged();
    }
}
