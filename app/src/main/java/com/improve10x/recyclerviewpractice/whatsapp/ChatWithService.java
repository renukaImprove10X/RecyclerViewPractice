package com.improve10x.recyclerviewpractice.whatsapp;

import com.improve10x.recyclerviewpractice.whatsapp.messages.Message;
import com.improve10x.recyclerviewpractice.whatsapp.templates.Template;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChatWithService {
    @GET("templates")
    Call<List<Template>> fetchTemplates();

    @GET("messageHistory")
    Call<List<Message>> fetchMessages();

}
