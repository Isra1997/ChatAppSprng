package com.example.Spring.MVC.service;

import com.example.Spring.MVC.mappers.MessageMapper;
import com.example.Spring.MVC.model.ChatForm;
import com.example.Spring.MVC.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {
    List<String> bandWords;
    MessageMapper messageMapper;

    public MessageListService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    private void createList(){
        this.bandWords = new ArrayList<>(List.of("bad","grumpy","sad"));
    }

    public List<ChatMessage> getMessages(String username) {
        List<ChatMessage> messages = messageMapper.getMessages(username);
        if( messages == null){
            return new ArrayList<>();
        }
        else {
            return messageMapper.getMessages(username);
        }

    }

    public void addToMessageList(ChatForm chatFormData,String username){
        //extract need information
        String message = chatFormData.getMessageText();


        //do dome logic according to the mode
        switch(chatFormData.getMode()){
            case "Shout":
                message = message.toUpperCase();
                break;
            case "Whisper":
                message = message.toLowerCase();
                break;
        }
        ChatMessage chatMessage = new ChatMessage(null,username,message);
        messageMapper.insertMessage(chatMessage);
    }

    public List<String> getBandWords() {
        return bandWords;
    }
}
