package com.whatapp.message.dao;

import com.whatapp.message.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MessageDAO extends JpaRepository<MessageEntity,Integer> {

    @Query("from MessageEntity where sendFrom =:sendFrom")
    List<MessageEntity> getUserMsg(int sendFrom);
    @Query("select message from MessageEntity where sendFrom =:sendFrom")
    String getMsg(int sendFrom);

    List<MessageEntity> findAllBySendTo(Integer sendTo);

}
