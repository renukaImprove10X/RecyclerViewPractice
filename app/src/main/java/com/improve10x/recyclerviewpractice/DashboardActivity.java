package com.improve10x.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.improve10x.recyclerviewpractice.filmDiary.movies.MoviesActivity;
import com.improve10x.recyclerviewpractice.filmDiary.series.SeriesActivity;
import com.improve10x.recyclerviewpractice.grocery.CategoriesActivity;
import com.improve10x.recyclerviewpractice.whatsapp.messages.MessageActivity;
import com.improve10x.recyclerviewpractice.whatsapp.templates.TemplatesActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtons();
    }

    private void setupButtons() {
        handleTemplates();
        handleMessages();
        handleSeries();
        handleMovies();
        handleGroceries();
    }

    private void handleGroceries() {
        Button groceryBtn = findViewById(R.id.grocery_btn);
        groceryBtn.setOnClickListener(view -> {
            Intent groceryIntent = new Intent(this, CategoriesActivity.class);
            startActivity(groceryIntent);
        });
    }

    private void handleMovies() {
        Button moviesBtn = findViewById(R.id.movie_btn);
        moviesBtn.setOnClickListener(view -> {
            Intent movieIntent = new Intent(this, MoviesActivity.class);
            startActivity(movieIntent);
        });
    }

    private void handleSeries() {
        Button seriesBtn = findViewById(R.id.series_btn);
        seriesBtn.setOnClickListener(view -> {
            Intent seriesIntent = new Intent(this, SeriesActivity.class);
            startActivity(seriesIntent);
        });
    }

    private void handleMessages() {
        Button messageBtn = findViewById(R.id.messages_btn);
        messageBtn.setOnClickListener(view -> {
            Intent messageIntent = new Intent(this, MessageActivity.class);
            startActivity(messageIntent);
        });
    }

    private void handleTemplates() {
        Button templateBtn = findViewById(R.id.templates_btn);
        templateBtn.setOnClickListener(view -> {
            Intent templateIntent = new Intent(this, TemplatesActivity.class);
            startActivity(templateIntent);
        });
    }
}