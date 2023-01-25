package com.example.chatapp.src.chat.model;

import lombok.*;

@Getter @Builder @Setter
@AllArgsConstructor @NoArgsConstructor
public class MessageModel {
    private String type;
    private String sender;
    private String roomCode;
    private String message;


    public void newConnect() {
        this.type = "new";
    }
    public void closeConnect() {
        this.type = "close";
    }
}
