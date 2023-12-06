package com.whatapp.message.controller;

import com.whatapp.message.dto.MessageDTO;
import com.whatapp.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

   // private final static Logger log = LoggerFactory.getLogger(MessageController.class);

    private final MessageService messageService;

    //localhost:8083/message/post
    @PostMapping("/post")
    public MessageDTO postMessage(@RequestBody MessageDTO messageDTO) {

        log.debug("MessageController::postMessage()  call stated");
        log.debug("MessageController::postMessage()  messageDTO {}{}", messageDTO, messageDTO);
       /* if (StringUtils.isBlank(messageDTO.getMessage())) {
            throw new RuntimeException("Message is Empty");
        }*/

  /*      try {
            messageService.postMessage(messageDTO);

            if (messageDTO.getSendTo() <= 0) {
                log.error("Invalid sender id - {}",messageDTO.getSendTo());
                // if (StringUtils.isBlank(messageDTO.getSendTo())) {
                throw new RuntimeException("Sendto  is Empty");
            }
        } catch (NullPointerException exception) {
            log.error("NullPointerException {}",exception);
            throw new RuntimeException("NullPointerException ");

        }catch (Throwable exception) {
            log.error("Exception {}",exception);
            throw new RuntimeException("Exception occurs while saving Message in DB");

        }*/
        return messageService.postMessage(messageDTO);

    }

    //localhost:8083/message/get/all
    @GetMapping("/get/{userId}")
    public List<MessageDTO> getMessage(@PathVariable("userId" ) Integer userId) {

        return messageService.getMessage(userId);
    }

    //localhost:8083/message/update
    @PutMapping("/update")

    public MessageDTO updateMessage(@RequestBody MessageDTO messageDTO) {
        log.debug("MessageController::postMessage()  messageDTO {}{}", messageDTO, messageDTO);

        return messageService.updateMessage(messageDTO);

    }

    //localhost:8083/message/delete
    @DeleteMapping("/delete/{id}")

    public String deleteMessage(@PathVariable Integer id) {
        log.debug("MessageController::deleteMessage() {} id1",id );
      //return  messageService.deleteMessage(id);
       // log.debug("MessageController::deleteMessage()  id1", );

        return messageService.deleteMessage(id) ;

    }

    /*TRACE
TRACE
DEBUG
INFO
WARN
ERROR
FATAL
*/
}
