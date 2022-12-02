package com.improve10x.recyclerviewpractice.whatsapp.messages;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.recyclerviewpractice.R;

public class MessageViewHolder extends RecyclerView.ViewHolder {
    public TextView nameTxt;
    public TextView phoneNumberTxt;
    public TextView messageTxt;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTxt = itemView.findViewById(R.id.name_txt);
        phoneNumberTxt = itemView.findViewById(R.id.phone_number_txt);
        messageTxt = itemView.findViewById(R.id.title_txt);
    }
}
