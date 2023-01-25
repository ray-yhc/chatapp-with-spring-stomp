package com.example.chatapp.src.chat.model;

import lombok.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomModel {
    private Long id;
    private String roomCode;
    private String roomName;
    private String profileImgUrl;
    private LocalDateTime recentDate;


    public static RoomModel create(String name) {
        RoomModel roomModel = new RoomModel();
        roomModel.roomCode = UUID.randomUUID().toString();
        roomModel.roomName = name;
        roomModel.recentDate = LocalDateTime.now(Clock.systemDefaultZone());
        return roomModel;
    }

//    public static String createRoomCode(){
//        return UUID.randomUUID().toString();
//    }

    private static String getDate() {
        Date date = new Date();
        return String.format("%1$tY-%1$tm-%1$td", date);
    }
}
