package com.example.chatapp.src.chat.model;

import lombok.*;

@Getter @Builder @Setter
@AllArgsConstructor @NoArgsConstructor
public class Message {
    private String type;
    private String sender;
    private String roomId;
    private String message;


    public void newConnect() {
        this.type = "new";
    }
    public void closeConnect() {
        this.type = "close";
    }
}
