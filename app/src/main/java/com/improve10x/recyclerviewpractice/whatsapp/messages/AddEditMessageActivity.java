package com.improve10x.recyclerviewpractice.whatsapp.messages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.ActivityAddEditMessageBinding;
import com.improve10x.recyclerviewpractice.whatsapp.ChatWithApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditMessageActivity extends AppCompatActivity {
    TextInputEditText nameTxt;
    TextInputEditText phoneNumberTxt;
    EditText messageTxt;
    private ActivityAddEditMessageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddEditMessageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initViews();
    }

    private void initViews() {
        nameTxt = binding.nameTxt;
        phoneNumberTxt = binding.phoneNumberTxt;
        messageTxt = binding.messageTxt;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_message_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.done) {
            addMessage(nameTxt.getText().toString(), phoneNumberTxt.getText().toString(), messageTxt.getText().toString());
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void addMessage(String name, String phoneNumber, String messageText) {
        Message message = new Message(name, phoneNumber, messageText);
        ChatWithApi api = new ChatWithApi();
        api.createChatWithService().addMessage(message)
                .enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Toast.makeText(AddEditMessageActivity.this, "Added new message", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(AddEditMessageActivity.this, "Failed to add message", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}