package com.example.chatapp.src.chat.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetRoomRes {
    private Long id;
    private String roomCode;
    private String roomName;
    private String profileImgUrl;
    private String recentChatMessage;
    private LocalDateTime recentTimestamp;
}
