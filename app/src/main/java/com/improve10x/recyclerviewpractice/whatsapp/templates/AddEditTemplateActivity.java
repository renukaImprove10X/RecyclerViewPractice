package com.improve10x.recyclerviewpractice.whatsapp.templates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.whatsapp.ChatWithApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditTemplateActivity extends AppCompatActivity {
    EditText messageTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_template);
        initViews();
    }

    private void initViews() {
        messageTxt = findViewById(R.id.message_txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.template_add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.done){
            addTemplate(messageTxt.getText().toString());
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void addTemplate(String message) {
        Template template = new Template(message);
        ChatWithApi api = new ChatWithApi();
        api.createChatWithService().addTemplate(template)
                .enqueue(new Callback<Template>() {
                    @Override
                    public void onResponse(Call<Template> call, Response<Template> response) {
                        Toast.makeText(AddEditTemplateActivity.this, "Added template", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Template> call, Throwable t) {
                        Toast.makeText(AddEditTemplateActivity.this, "Failed to add template", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}