package com.improve10x.recyclerviewpractice.whatsapp.templates;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;

public class TemplateViewHolder extends RecyclerView.ViewHolder {
    public TextView templateTxt;
    public TemplateViewHolder(@NonNull View itemView) {
        super(itemView);
        templateTxt = itemView.findViewById(R.id.template_txt);
    }
}
