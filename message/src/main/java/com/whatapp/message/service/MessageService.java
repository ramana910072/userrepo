package com.whatapp.message.service;

import com.whatapp.message.dto.MessageDTO;
import com.whatapp.message.entity.MessageEntity;

import java.util.List;

public interface MessageService {

     MessageDTO postMessage(MessageDTO messageDTO);
    List<MessageDTO> getMessage(Integer userId);
    MessageDTO updateMessage(MessageDTO messageDTO);
    String deleteMessage(Integer id);
}
