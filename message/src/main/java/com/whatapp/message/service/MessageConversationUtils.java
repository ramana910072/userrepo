package com.whatapp.message.service;


import com.whatapp.message.dto.MessageDTO;
import com.whatapp.message.entity.MessageEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class MessageConversationUtils {

    public static List<MessageDTO> convertToMessageDtos(List<MessageEntity> messageEntities) {
        List<MessageDTO> messageDTOS = new ArrayList<>();
        for (MessageEntity messageEntity : messageEntities) {
            MessageDTO messageDTO = new MessageDTO();
            messageDTO.setId(messageEntity.getId());
            messageDTO.setMessage(messageEntity.getMessage());
            messageDTO.setCreatedAt(messageEntity.getCreatedAt());
            messageDTO.setUpdatedAt(messageEntity.getUpdatedAt());
            messageDTO.setSendFrom(messageEntity.getSendFrom());
            messageDTO.setSendTo(messageEntity.getSendTo());
            messageDTO.setStatus(messageEntity.getStatus());
            messageDTOS.add(messageDTO);
        }
        return messageDTOS;
    }
}
