package com.improve10x.recyclerviewpractice.whatsapp.templates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.ActivityMainBinding;
import com.improve10x.recyclerviewpractice.databinding.ActivityTemplatesBinding;
import com.improve10x.recyclerviewpractice.whatsapp.ChatWithApi;
import com.improve10x.recyclerviewpractice.whatsapp.messages.MessageActivity;
import com.improve10x.recyclerviewpractice.whatsapp.templates.Template;
import com.improve10x.recyclerviewpractice.whatsapp.templates.TemplateAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemplatesActivity extends AppCompatActivity {

    public ArrayList<Template> templates = new ArrayList<Template>();
    RecyclerView templatesRv;
    TemplateAdapter templateAdapter;
    ProgressBar progressBar;
    private ActivityTemplatesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTemplatesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().setTitle("Templates");
        initViews();
        showProgress();
        setupRecyclerView();
        fetchData();
    }

    private void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void fetchData() {
        ChatWithApi api = new ChatWithApi();
        Call<List<Template>> call = api.createChatWithService().fetchTemplates();
        call.enqueue(new Callback<List<Template>>() {
            @Override
            public void onResponse(Call<List<Template>> call, Response<List<Template>> response) {
                hideProgress();
                templateAdapter.setData(response.body());
                Toast.makeText(TemplatesActivity.this, "Fetched templates", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Template>> call, Throwable t) {
                hideProgress();
                Toast.makeText(TemplatesActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    private void initViews() {
        progressBar = binding.progressBar;
        templatesRv = binding.templatesRv;
        templateAdapter = new TemplateAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.templates_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.template_add) {
            Intent addIntent = new Intent(this, AddEditTemplateActivity.class);
            startActivity(addIntent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void setupRecyclerView() {
        templatesRv = findViewById(R.id.templates_rv);
        templatesRv.setLayoutManager(new LinearLayoutManager(this));
        templateAdapter = new TemplateAdapter();
        templateAdapter.setData(templates);
        templatesRv.setAdapter(templateAdapter);
    }
}