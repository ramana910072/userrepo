package com.whatapp.message.service;

import com.whatapp.message.controller.MessageController;
import com.whatapp.message.dao.MessageDAO;
import com.whatapp.message.dto.MessageDTO;
import com.whatapp.message.entity.MessageEntity;
import com.whatapp.message.exception.ResourceCreationException;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final static Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    private final MessageDAO messageDAO;

    @Override
    public MessageDTO postMessage(MessageDTO messageDTO) {
        log.debug("MessageServiceImpl::postMessage()  call stated");
        try {
            MessageEntity messageEntity = new MessageEntity();
            messageEntity.setId(messageDTO.getId());
            if (messageDAO.existsById(messageDTO.getId())){
                throw new ResourceCreationException("Exception occurs while creating resource");
            }
            messageEntity.setMessage(messageDTO.getMessage());
            messageEntity.setCreatedAt(messageDTO.getCreatedAt());
            messageEntity.setUpdatedAt(messageDTO.getUpdatedAt());
            messageEntity.setSendFrom(messageDTO.getSendFrom());
            messageEntity.setSendTo(messageDTO.getSendTo());
            messageEntity.setStatus(messageDTO.getStatus());
            messageDAO.save(messageEntity);
            log.debug("Message saved in DB  messageEntity {}", messageEntity);
        } catch (ResourceCreationException exception) {
           throw exception;
        }

        return messageDTO;
    }

    @Override
    public List<MessageDTO> getMessage(Integer userId) {
        List<MessageEntity> messageEntities = messageDAO.findAllBySendTo(userId);
        return MessageConversationUtils.convertToMessageDtos(messageEntities);

    }


    @Override
    public MessageDTO updateMessage(MessageDTO messageDTO) {

        Optional<MessageEntity> Optional = messageDAO.findById(messageDTO.getId());
        if (Optional.isEmpty()) {
            log.error("Message not found for id -{}", messageDTO.getId());
            throw new RuntimeException("Message Entity not found");
        }

        MessageEntity messageEntity = Optional.get();
        if (StringUtils.isNotBlank(messageDTO.getMessage())) {
            messageEntity.setMessage(messageDTO.getMessage());
        }

        messageEntity = messageDAO.saveAndFlush(messageEntity);
        return new MessageDTO(messageEntity.getMessage());


    }

    @Override
    public String deleteMessage(Integer id) {
        Optional<MessageEntity> option = messageDAO.findById(id);

        if (option.isEmpty()) {
            throw new RuntimeException("Id not found");
        }
        messageDAO.delete(option.get());
        return "Successfully deleted";
    }
}
