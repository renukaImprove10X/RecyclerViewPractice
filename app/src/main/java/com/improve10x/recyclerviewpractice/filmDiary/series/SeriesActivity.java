package com.improve10x.recyclerviewpractice.filmDiary.series;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.filmDiary.FilmDiaryApi;
import com.improve10x.recyclerviewpractice.filmDiary.FilmDiaryService;
import com.improve10x.recyclerviewpractice.filmDiary.movies.MoviesActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesActivity extends AppCompatActivity {
    public List<Series> series;
    SeriesAdapter seriesAdapter;
    ProgressBar progressBar;
    RecyclerView seriesRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        getSupportActionBar().setTitle("Series");
        setupData();
        setupViews();
        setupRecyclerView();
        fetchData();
    }

    private void showProgress(){
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress(){
        progressBar.setVisibility(View.GONE);
    }

    private void setupViews() {
        progressBar = findViewById(R.id.series_progress_bar);
        seriesRv = findViewById(R.id.series_rv);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.series_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.series_add) {
            Intent intent = new Intent(this, AddEditSeriesActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void fetchData() {
        showProgress();
        FilmDiaryApi api = new FilmDiaryApi();
        FilmDiaryService seriesService = api.createFilmDiaryService();
        Call<List<Series>> series = seriesService.fetchSeries();
        series.enqueue(new Callback<List<Series>>() {
            @Override
            public void onResponse(Call<List<Series>> call, Response<List<Series>> response) {
                hideProgress();
                List<Series> seriesList = response.body();
                seriesAdapter.setData(seriesList);
            }

            @Override
            public void onFailure(Call<List<Series>> call, Throwable t) {
                hideProgress();
            }
        });
    }

    private void setupRecyclerView() {
        seriesRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        seriesAdapter = new SeriesAdapter();
        seriesAdapter.setData(series);
        seriesRv.setAdapter(seriesAdapter);
    }

    private void setupData() {
        series = new ArrayList<>();
        Series series = new Series("1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxFQlfyjuPDaN29rN-bcBwQgJlbv0q5CjqNQ&usqp=CAU", "Comedy Movies");
        this.series.add(series);
        Series series2 = new Series("2", "https://wallpaperaccess.com/full/1280586.jpg", "Horror Movies");
        this.series.add(series2);
    }

}