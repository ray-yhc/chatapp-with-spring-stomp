package com.example.chatapp.src.chat;


import com.example.chatapp.src.chat.Repository.ChatRepository;
import com.example.chatapp.src.chat.Repository.MemoryChatRepository;
import com.example.chatapp.src.chat.model.ChatRoom;
import com.example.chatapp.src.chat.model.Room;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    //채팅방 불러오기
    public List<Room> findAllRoom() {
        return chatRepository.findAllRooms();
    }

    //채팅방 하나 불러오기
    public Room findRoomById(String roomId) {
        return chatRepository.findRoomById(roomId);
    }

    //채팅방 생성
    public Room createRoom(String name) {
        return chatRepository.createRoom(name);
    }
}