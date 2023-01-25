package com.example.chatapp.src.chat.Repository;

import com.example.chatapp.src.chat.model.ChatModel;
import com.example.chatapp.src.chat.model.RoomModel;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository @Deprecated
public class MemoryChatRepository implements ChatRepository{

    private Map<String, RoomModel> chatRoomsMemory;
    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        chatRoomsMemory = new LinkedHashMap<>();

        // todo: 테스트 후 제거
        createRoom("sample room");
    }

    @Override
    public RoomModel createRoom(String name) {
        RoomModel roomModel = RoomModel.create(name);
        chatRoomsMemory.put(roomModel.getRoomCode(), roomModel);
        return roomModel;
    }

    @Override
    public List<RoomModel> findAllRooms() {
        List<RoomModel> list = new ArrayList<>(chatRoomsMemory.values());
        // todo : 시간순 정렬 필요 !
        return list;
    }

    @Override
    public RoomModel findRoomByRoomCode(String roomCode ) {
        return chatRoomsMemory.get(roomCode);
    }

    @Override
    public RoomModel findRoomById(Long roomId) {
        return null;
    }

    @Override
    public ChatModel addChat(ChatModel chatModel) {
        return null;
    }
}
