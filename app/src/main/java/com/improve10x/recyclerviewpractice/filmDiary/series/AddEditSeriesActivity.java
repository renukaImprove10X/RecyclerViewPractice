package com.improve10x.recyclerviewpractice.filmDiary.series;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.ActivityAddEditSeriesBinding;
import com.improve10x.recyclerviewpractice.filmDiary.FilmDiaryApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditSeriesActivity extends AppCompatActivity {
    EditText seriesIdTxt;
    EditText seriesNameTxt;
    EditText seriesImgUrlTxt;
    private ActivityAddEditSeriesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddEditSeriesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
    }

    private void initViews() {
        seriesIdTxt = binding.seriesIdTxt;
        seriesNameTxt = binding.seriesNameTxt;
        seriesImgUrlTxt = binding.seriesImgUrlTxt;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_series_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.done) {
            addSeries(seriesIdTxt.getText().toString(),
                    seriesImgUrlTxt.getText().toString(),
                    seriesNameTxt.getText().toString());
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void addSeries(String seriesId, String imageUrl, String seriesName) {
        Series series = new Series(seriesId, imageUrl, seriesName);
        FilmDiaryApi api = new FilmDiaryApi();
        api.createFilmDiaryService().addSeries(series)
                .enqueue(new Callback<Series>() {
                    @Override
                    public void onResponse(Call<Series> call, Response<Series> response) {
                        Toast.makeText(AddEditSeriesActivity.this, "Added series successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Series> call, Throwable t) {
                        Toast.makeText(AddEditSeriesActivity.this, "Failed to add series", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}