package com.improve10x.recyclerviewpractice.filmDiary.movies;

import com.google.gson.annotations.SerializedName;

public class Movie {
    public String imageUrl;
    public String seriesId;
    public String movieId;
    @SerializedName("name")
    public String title;

    public Movie() {
    }

    public Movie(String seriesId, String movieId, String imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.seriesId = seriesId;
        this.movieId = movieId;
        this.title = title;
    }
}
