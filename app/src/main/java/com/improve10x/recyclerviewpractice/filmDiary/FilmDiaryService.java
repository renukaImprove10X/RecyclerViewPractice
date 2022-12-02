package com.improve10x.recyclerviewpractice.filmDiary;

import com.improve10x.recyclerviewpractice.filmDiary.movies.Movie;
import com.improve10x.recyclerviewpractice.filmDiary.series.Series;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FilmDiaryService {
    @GET("series")
    Call<List<Series>> fetchSeries();

    @POST("renukaSeries")
    Call<Series> addSeries(@Body Series series);

    @GET("movies")
    Call<List<Movie>> fetchMovies();

    @POST("renukaMovies")
    Call<Movie> addMovie(@Body Movie movie);
}
