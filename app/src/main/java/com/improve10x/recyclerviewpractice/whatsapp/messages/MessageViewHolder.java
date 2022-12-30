package com.improve10x.recyclerviewpractice.whatsapp.messages;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.MessageItemBinding;

public class MessageViewHolder extends RecyclerView.ViewHolder {
    MessageItemBinding binding;

    public MessageViewHolder(MessageItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
