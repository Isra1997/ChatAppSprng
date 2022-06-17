package com.example.Spring.MVC.mappers;

import com.example.Spring.MVC.model.ChatMessage;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;



@Mapper
public interface MessageMapper {

    @Select("Select * from MESSAGES where username=#{username}")
    ArrayList<ChatMessage> getMessages(String username);

    @Insert("Insert  into MESSAGES(username,messageText) " +
            "Values(#{username},#{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insertMessage(ChatMessage message);

    @Delete("Delete from MESSAGES where messageId=#{Id}")
    void deleteMessage(Integer Id);



}
