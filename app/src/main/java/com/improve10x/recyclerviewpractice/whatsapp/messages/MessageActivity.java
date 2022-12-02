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
    public ArrayList<Message> messages;
    MessageAdapter messageAdapter;
    RecyclerView messagesRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        getSupportActionBar().setTitle("Messages");
        initViews();
        setupData();
        setupRecyclerView();
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
            Intent addIntent = new Intent(this, TemplatesActivity.class);
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

    private void setupData() {
        messages = new ArrayList<>();
        Message message = new Message("1", "Aravind", "+91 9000540052", "Hi, Welcome to Improve 10X");
        messages.add(message);
        Message message2 = new Message("2", "Ramesh", "+91 9000540052", "Hi, Welcome to Improve 10X");
        messages.add(message2);
        Message message3 = new Message("3", "", "+91 9000540052", "Hi, call me when you see the message");
        messages.add(message3);
        Message message4 = new Message("4", "Swiggy Delivery", "+91 9000540052", "full address");
        messages.add(message4);
        Message message5 = new Message("5", "Renuka Venkata Ramani", "+91 9000540052", "Are you available for this Sunday?\n\nWe can have a call and discuss the movie");
        messages.add(message5);
    }

}