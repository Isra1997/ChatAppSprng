package com.example.Spring.MVC.controllers;

import com.example.Spring.MVC.model.ChatMessage;
import com.example.Spring.MVC.model.MessageForm;
import com.example.Spring.MVC.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/home")
    public String homePage(@ModelAttribute("newMessage") ChatMessage newMessage , Model model){
        model.addAttribute("greetings", this.messageListService.getMessages(""));
        return "home";
    }

//    @PostMapping("/home")
//    public String postHome(@ModelAttribute("newMessage") ChatMessage newMessage, Model model){
//        messageListService.addToMessageList(newMessage);
//        model.addAttribute("greetings",this.messageListService.getMessages(""));
//        newMessage.setMessage("");
//        return "home";
//    }



}
