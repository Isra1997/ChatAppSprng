package com.example.Spring.MVC.controllers;


import com.example.Spring.MVC.model.ChatForm;
import com.example.Spring.MVC.model.ChatMessage;
import com.example.Spring.MVC.service.MessageListService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {

    private MessageListService messageListService;

    public ChatController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/chat")
    public String getChatApp(@ModelAttribute("chatFormData") ChatForm chatFormData, Model model){
        model.addAttribute("messageList", messageListService.getMessages(getUsername()));
        return "chat";
    }


    @PostMapping("/chat")
    public String addMessage(@ModelAttribute("chatFormData") ChatForm chatFormData, Model model){
        if(!messageListService.getBandWords().contains(chatFormData.getMessageText())){
            messageListService.addToMessageList(chatFormData,getUsername());
            model.addAttribute("isBand",false);
        }else{
            model.addAttribute("isBand",true);
        }

        model.addAttribute("messageList", messageListService.getMessages(getUsername()));
        //clearing form data
        chatFormData.setMessageText("");
        chatFormData.setMode("Say");
        chatFormData.setUsername("");
        return "chat";
    }

    public String getUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
             return ((UserDetails)principal).getUsername();
        } else {
             return principal.toString();
        }
    }
}
