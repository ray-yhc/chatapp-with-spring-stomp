package com.example.chatapp.src.chat.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Builder @Setter
@AllArgsConstructor @NoArgsConstructor
public class MessageModel {
    private String type;
    private String sender;
    private String roomCode;
    private String message;
    private LocalDateTime timestamp;


    public void newConnect() {
        this.type = "new";
    }
    public void closeConnect() {
        this.type = "close";
    }
}
