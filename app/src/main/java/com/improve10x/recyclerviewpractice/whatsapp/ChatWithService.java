package com.improve10x.recyclerviewpractice.whatsapp;

import com.improve10x.recyclerviewpractice.whatsapp.messages.Message;
import com.improve10x.recyclerviewpractice.whatsapp.templates.Template;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ChatWithService {
    @GET("renukaTemplates")
    Call<List<Template>> fetchTemplates();

    @POST("renukaTemplates")
    Call<Template> addTemplate(@Body Template template);

    @GET("renukaMessagesHistory")
    Call<List<Message>> fetchMessages();

    @POST("renukaMessagesHistory")
    Call<Message> addMessage(@Body Message message);

}
