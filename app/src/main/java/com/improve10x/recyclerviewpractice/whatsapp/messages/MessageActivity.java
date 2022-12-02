package com.improve10x.recyclerviewpractice.whatsapp.messages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.whatsapp.ChatWithApi;
import com.improve10x.recyclerviewpractice.whatsapp.ChatWithService;
import com.improve10x.recyclerviewpractice.whatsapp.templates.TemplatesActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageActivity extends AppCompatActivity {
    public ArrayList<Message> messages = new ArrayList<>();;
    MessageAdapter messageAdapter;
    RecyclerView messagesRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        getSupportActionBar().setTitle("Messages");
        initViews();
        setupRecyclerView();
        fetchData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    private void initViews() {
        messageAdapter = new MessageAdapter();
        messagesRv = findViewById(R.id.messages_rv);
    }

    private void fetchData() {
        ChatWithApi chatWithApi = new ChatWithApi();
        ChatWithService service = chatWithApi.createChatWithService();
        Call<List<Message>> call = service.fetchMessages();
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
               messageAdapter.setData(response.body());
                Toast.makeText(MessageActivity.this, "Successfully fetched data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Toast.makeText(MessageActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.messages_menu, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add){
            Intent addIntent = new Intent(this, AddEditMessageActivity.class);
            startActivity(addIntent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void setupRecyclerView() {
        messagesRv.setLayoutManager(new LinearLayoutManager(this));

        messageAdapter.setData(messages);
        messagesRv.setAdapter(messageAdapter);
    }

}