package com.improve10x.recyclerviewpractice.whatsapp.messages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.whatsapp.templates.TemplatesActivity;

import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {
    public ArrayList<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        getSupportActionBar().setTitle("Messages");
        setupData();
        setupRecyclerView();
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
        RecyclerView messagesRv = findViewById(R.id.messages_rv);
        messagesRv.setLayoutManager(new LinearLayoutManager(this));
        MessageAdapter messageAdapter = new MessageAdapter();
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