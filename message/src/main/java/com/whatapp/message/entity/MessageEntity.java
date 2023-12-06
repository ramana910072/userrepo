package com.whatapp.message.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "messageEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {

    @Id
    private Integer id;
    private String message;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Integer sendTo;
    private Integer sendFrom;//user id
    private String status;
}
