package com.improve10x.recyclerviewpractice.whatsapp.messages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;
import com.improve10x.recyclerviewpractice.databinding.MessageItemBinding;
import com.improve10x.recyclerviewpractice.whatsapp.templates.Template;
import com.improve10x.recyclerviewpractice.whatsapp.templates.TemplateViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    public List<Message> messages;

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MessageItemBinding binding = MessageItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        MessageViewHolder messageViewHolder = new MessageViewHolder(binding);
        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.binding.nameTxt.setText(message.name);
        holder.binding.phoneNumberTxt.setText(message.phoneNumber);
        holder.binding.titleTxt.setText(message.messageText);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public void setData(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }
}
