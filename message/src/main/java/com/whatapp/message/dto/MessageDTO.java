package com.whatapp.message.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class   MessageDTO {

    private Integer id;
    @NotBlank(message = "Message should not be blank")
   /* @Min(2)
    @Max(5)*/
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")

    private String message;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private int sendTo;
    private int sendFrom;
    private String status;


    public MessageDTO(String message) {
        this.message = message;
    }

    /* "id": 1,
    "message":"Hi Ramana",
    "createdAt":"Hello",
    "updatedAt":"Hello",
    "sendTo":"123",
    "sendFrom":"Hello",
    "status":"Pass"
"id": 2,
    "message":"Hi Ramana",
    "createdAt":"Hello",
    "updatedAt":"Hello",
    "sendTo":"123",
    "sendFrom":"Hello",
    "status":"Pass"
"id": 1,
    "message":"Hi Ramana",
    "createdAt":"Hello",
    "updatedAt":"Hello",
    "sendTo":"231",
    "sendFrom":"Hello",
    "status":"Pass"
     */
}
