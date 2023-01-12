package com.example.chatapp.src.chat.Repository;

import com.example.chatapp.src.chat.model.Chat;
import com.example.chatapp.src.chat.model.ChatRoom;
import com.example.chatapp.src.chat.model.Room;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryChatRepository implements ChatRepository{

    private Map<String, Room> chatRoomsMemory;
    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        chatRoomsMemory = new LinkedHashMap<>();

        // todo: 테스트 후 제거
        createRoom("sample room");
    }

    @Override
    public Room createRoom(String name) {
        Room room = Room.create(name);
        chatRoomsMemory.put(room.getRoomId(), room);
        return room;
    }

    @Override
    public List<Room> findAllRooms() {
        List<Room> list = new ArrayList<>(chatRoomsMemory.values());
        // todo : 시간순 정렬 필요 !
        return list;
    }

    @Override
    public Room findRoomById(String roomId ) {
        return chatRoomsMemory.get(roomId);
    }

    @Override
    public Chat addChat(Chat chat) {
        return null;
    }
}
