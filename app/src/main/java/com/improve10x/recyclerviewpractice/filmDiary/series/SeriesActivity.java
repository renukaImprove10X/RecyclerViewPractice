package com.improve10x.recyclerviewpractice.filmDiary.series;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.filmDiary.FilmDiaryApi;
import com.improve10x.recyclerviewpractice.filmDiary.FilmDiaryService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesActivity extends AppCompatActivity {
    public List<Series> series;
    SeriesAdapter seriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        getSupportActionBar().setTitle("Series");
        setupData();
        setupRecyclerView();
        fetchData();
    }

    private void fetchData() {
        FilmDiaryApi api = new FilmDiaryApi();
        FilmDiaryService seriesService = api.createFilmDiaryService();
        Call<List<Series>> series = seriesService.fetchSeries();
        series.enqueue(new Callback<List<Series>>() {
            @Override
            public void onResponse(Call<List<Series>> call, Response<List<Series>> response) {
                List<Series> seriesList = response.body();
                seriesAdapter.setData(seriesList);
            }

            @Override
            public void onFailure(Call<List<Series>> call, Throwable t) {

            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView seriesRv = findViewById(R.id.series_rv);
        seriesRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        seriesAdapter = new SeriesAdapter();
        seriesAdapter.setData(series);
        seriesRv.setAdapter(seriesAdapter);
    }

    private void setupData() {
        series = new ArrayList<>();
        Series series = new Series("1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxFQlfyjuPDaN29rN-bcBwQgJlbv0q5CjqNQ&usqp=CAU","Comedy Movies");
        this.series.add(series);
        Series series2 = new Series("2", "https://wallpaperaccess.com/full/1280586.jpg", "Horror Movies");
        this.series.add(series2);
    }

}