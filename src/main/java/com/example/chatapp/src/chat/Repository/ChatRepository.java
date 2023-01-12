package com.example.chatapp.src.chat.Repository;

import com.example.chatapp.src.chat.model.Chat;
import com.example.chatapp.src.chat.model.Room;

import java.util.List;

public interface ChatRepository {
    // 채팅방 생성하기
    public Room createRoom(String name);
    // 모든 채팅방 정보 불러오기
    public List<Room> findAllRooms();
    // 1개 채팅방 정보 불러오기
    public Room findRoomById(String roomId );
    // 챗 저장하기
    public Chat addChat(Chat chat);
}
