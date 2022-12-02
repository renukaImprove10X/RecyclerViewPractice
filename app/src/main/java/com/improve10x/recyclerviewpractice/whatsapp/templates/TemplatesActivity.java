package com.improve10x.recyclerviewpractice.whatsapp.templates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.whatsapp.messages.MessageActivity;
import com.improve10x.recyclerviewpractice.whatsapp.templates.Template;
import com.improve10x.recyclerviewpractice.whatsapp.templates.TemplateAdapter;

import java.util.ArrayList;

public class TemplatesActivity extends AppCompatActivity {

    public ArrayList<Template> templates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
        getSupportActionBar().setTitle("Templates");
        setupData();
        setupRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.templates_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.template_add) {
            Intent addIntent = new Intent(this, MessageActivity.class);
            startActivity(addIntent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void setupRecyclerView() {
        RecyclerView templatesRv = findViewById(R.id.templates_rv);
        templatesRv.setLayoutManager(new LinearLayoutManager(this));
        TemplateAdapter templateAdapter = new TemplateAdapter();
        templateAdapter.setData(templates);
        templatesRv.setAdapter(templateAdapter);
    }

    private void setupData() {
        templates = new ArrayList<Template>();
        Template template1 = new Template();
        template1.templateId = "1";
        template1.messageText = "Hi,\nWelcome to Improve 10X.";
        templates.add(template1);
        Template template2 = new Template();
        template2.templateId = "2";
        template2.messageText = "Hi, I'm busy.I'll call you later";
        templates.add(template2);
        Template template3 = new Template();
        template3.templateId = "3";
        template3.messageText = "Hi,\ncall me when you see the message";
        templates.add(template3);
        Template template4 = new Template();
        template4.templateId = "4";
        template4.messageText = "-Hi, Please find my contact details\nName: Viswanath Kumar Sandu\ncompany: Improve 10X\nMobile: +919000450052";
        templates.add(template4);
        Template template5 = new Template();
        template5.templateId = "5";
        template5.messageText = "Hi, Please find my contact details\nAccount Number: 68797675768957\nBank: ICICI Bank\nIFSC: ICICI0003456";
        templates.add(template5);
    }
}