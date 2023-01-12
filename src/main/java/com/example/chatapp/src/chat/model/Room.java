package com.example.chatapp.src.chat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Room {
    private String roomId;
    private String roomName;
    // profileImg
    private String recentDate;


    public static Room create(String name) {
        Room room = new Room();
        room.roomId = UUID.randomUUID().toString();
        room.roomName = name;
        room.recentDate = getDate();
        return room;
    }

    private static String getDate() {
        Date date = new Date();
        return String.format("%1$tY-%1$tm-%1$td", date);
    }
}
