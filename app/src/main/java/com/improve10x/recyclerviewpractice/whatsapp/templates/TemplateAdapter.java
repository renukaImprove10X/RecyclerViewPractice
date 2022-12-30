package com.improve10x.recyclerviewpractice.whatsapp.templates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.TemplateItemBinding;

import java.util.ArrayList;
import java.util.List;

public class TemplateAdapter extends RecyclerView.Adapter<TemplateViewHolder> {
    public List<Template> templates;

    @NonNull
    @Override
    public TemplateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TemplateItemBinding binding = TemplateItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        TemplateViewHolder templateViewHolder = new TemplateViewHolder(binding);
        return templateViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateViewHolder holder, int position) {
        Template template = templates.get(position);
        holder.binding.templateTxt.setText(template.messageText);
    }

    @Override
    public int getItemCount() {
        return templates.size();
    }

    public void setData(List<Template> templates) {
        this.templates = templates;
        notifyDataSetChanged();
    }
}
