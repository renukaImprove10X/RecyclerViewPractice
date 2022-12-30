package com.improve10x.recyclerviewpractice.whatsapp.templates;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.TemplateItemBinding;

public class TemplateViewHolder extends RecyclerView.ViewHolder {
    public TemplateItemBinding binding;
    public TemplateViewHolder(TemplateItemBinding binding) {
        super(binding.getRoot());
       this.binding = binding;
    }
}
