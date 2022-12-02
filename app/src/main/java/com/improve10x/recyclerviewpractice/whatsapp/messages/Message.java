package com.improve10x.recyclerviewpractice.whatsapp.messages;

public class Message {
    public String messageId;
    public String name;
    public String phoneNumber;
    public String messageText;

    public Message() {
    }

    public Message(String messageId, String name, String phoneNumber, String messageText) {
        this.messageId = messageId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.messageText = messageText;
    }

    public Message(String name, String phoneNumber, String messageText) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.messageText = messageText;
    }
}
