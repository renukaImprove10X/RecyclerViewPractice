package com.improve10x.recyclerviewpractice.filmDiary.movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.ActivityAddEditMovieBinding;
import com.improve10x.recyclerviewpractice.databinding.ActivityAddEditSeriesBinding;
import com.improve10x.recyclerviewpractice.filmDiary.FilmDiaryApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditMovieActivity extends AppCompatActivity {
    EditText idTxt;
    EditText nameTxt;
    Spinner seriesSp;
    EditText imageUrlTxt;
    EditText descriptionTxt;
    ArrayAdapter<String> spinnerAdapter;
    ArrayList<String> seriesList = new ArrayList<>();
    int seriesId;
    private ActivityAddEditMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddEditMovieBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
        inflateSpinner();
    }

    private void initViews() {
        idTxt = binding.idTxt;
        nameTxt = binding.nameTxt;
        seriesSp = binding.seriesSp;
        imageUrlTxt = binding.imageUrlTxt;
        descriptionTxt = binding.descriptionTxt;
    }

    private void inflateSpinner() {
        seriesList.add("Horror movies");
        seriesList.add("1990's Telugu Movies");
        seriesList.add("Allu Arjun Hits");
        spinnerAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, seriesList);
        seriesSp.setAdapter(spinnerAdapter);
        seriesSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                seriesId = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_edit_movie_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.done) {
            addMovie(idTxt.getText().toString(),
                    nameTxt.getText().toString(),
                    seriesId,
                    imageUrlTxt.getText().toString(),
                    descriptionTxt.getText().toString());
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void addMovie(String id, String name, int seriesId, String imageUrl, String description) {
        Movie movie = new Movie(Integer.toString(seriesId), id, imageUrl, name);
        FilmDiaryApi api = new FilmDiaryApi();
        api.createFilmDiaryService().addMovie(movie)
                .enqueue(new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        Toast.makeText(AddEditMovieActivity.this, "Added movie", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {
                        Toast.makeText(AddEditMovieActivity.this, "Failed to add movie", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}