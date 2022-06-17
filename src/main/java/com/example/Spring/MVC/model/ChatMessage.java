package com.example.Spring.MVC.model;

public class ChatMessage {
    Integer messageId;

    String username;

    String messageText;

    public ChatMessage(Integer messageId,String username, String message) {
        this.messageId = messageId;
        this.username = username;
        this.messageText = message;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
