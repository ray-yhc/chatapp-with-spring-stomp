package com.example.chatapp.src.chat;


import com.example.chatapp.src.chat.Repository.ChatRepository;
import com.example.chatapp.src.chat.model.MessageModel;
import com.example.chatapp.src.chat.model.RoomModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ChatService {

    private final ChatRepository chatRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    //채팅방 불러오기
    public List<RoomModel> findAllRoom() {
        return chatRepository.findAllRooms();
    }

    //채팅방 하나 불러오기
    public RoomModel findRoomByRoomCode(String roomCode) {
        return chatRepository.findRoomByRoomCode(roomCode);
    }

    //채팅방 생성
    public RoomModel createRoom(String name) {
        return chatRepository.createRoom(name);
    }

    /**
     * 채팅 전송정보 기록하기
     */
    void addChat(MessageModel messageModel) {
        chatRepository.addChat(messageModel);
    }
}