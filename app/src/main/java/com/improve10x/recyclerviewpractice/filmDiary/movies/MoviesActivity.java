package com.improve10x.recyclerviewpractice.filmDiary.movies;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.filmDiary.FilmDiaryApi;
import com.improve10x.recyclerviewpractice.filmDiary.FilmDiaryService;
import com.improve10x.recyclerviewpractice.filmDiary.series.SeriesActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesActivity extends AppCompatActivity {
    public ArrayList<Movie> movies;
    public MoviesAdapter moviesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        getSupportActionBar().setTitle("Movies");
        setupData();
        setupRecyclerView();
        fetchData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.movies_add){
            Intent intent = new Intent(this, SeriesActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void fetchData() {
        FilmDiaryApi api = new FilmDiaryApi();
        FilmDiaryService filmDiaryService = api.createFilmDiaryService();
        Call<List<Movie>> call = filmDiaryService.fetchMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                moviesAdapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(MoviesActivity.this, "Uh-oh, something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView messagesRv = findViewById(R.id.series_rv);
        messagesRv.setLayoutManager(new GridLayoutManager(this, 2));
        moviesAdapter = new MoviesAdapter();
        moviesAdapter.setData(movies);
        messagesRv.setAdapter(moviesAdapter);
    }

    private void setupData() {
        movies = new ArrayList<>();
        Movie movie = new Movie("1", "1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxFQlfyjuPDaN29rN-bcBwQgJlbv0q5CjqNQ&usqp=CAU","Comedy Movies");
        this.movies.add(movie);
        Movie movie2 = new Movie("1", "2", "https://wallpaperaccess.com/full/1280586.jpg", "Horror Movies");
        this.movies.add(movie2);
    }

}