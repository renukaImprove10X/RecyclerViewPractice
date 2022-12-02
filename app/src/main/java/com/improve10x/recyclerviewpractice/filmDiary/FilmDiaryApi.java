package com.improve10x.recyclerviewpractice.filmDiary;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmDiaryApi {
    public FilmDiaryService createFilmDiaryService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crudcrud.com/api/479dd07f8c1d482e9219f7dcb48e25f4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FilmDiaryService service = retrofit.create(FilmDiaryService.class);
        return service;
    }
}
