package com.improve10x.recyclerviewpractice.filmDiary;

import com.improve10x.recyclerviewpractice.filmDiary.movies.Movie;
import com.improve10x.recyclerviewpractice.filmDiary.series.Series;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmDiaryService {
    @GET("series")
    Call<List<Series>> fetchSeries();

    @GET("movies")
    Call<List<Movie>> fetchMovies();
}
