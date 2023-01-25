package com.example.chatapp.src.chat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChatModel {
    private long id;
    private String type;
    private String sender;
    private String roomId;
    private Object data;
}
