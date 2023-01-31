package com.example.chatapp.src.chat.Repository;

import com.example.chatapp.src.chat.model.MessageModel;
import com.example.chatapp.src.chat.model.RoomModel;

import java.util.List;

public interface ChatRepository {
    // 채팅방 생성하기
    public RoomModel createRoom(String name);
    // 모든 채팅방 정보 불러오기
    public List<RoomModel> findAllRooms();
    // roomCode를 이용해 1개 채팅방 정보 불러오기
    public RoomModel findRoomByRoomCode(String roomCode );
    // room id 이용해 1개 채팅방 정보 불러오기
    public RoomModel findRoomById(Long roomId);
    // 챗 저장하기
    public long addChat(MessageModel messageModel);
}
