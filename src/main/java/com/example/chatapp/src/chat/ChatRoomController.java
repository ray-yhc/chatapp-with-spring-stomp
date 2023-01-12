package com.example.chatapp.src.chat;


import com.example.chatapp.src.chat.model.ChatRoom;
import com.example.chatapp.src.chat.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/chat")
public class ChatRoomController {
    private final ChatService chatService;

    /**
     * 모든 채팅방 목록 반환
     */
    @GetMapping("/room")
    @ResponseBody
    public List<Room> room() {
        return chatService.findAllRoom();
    }

    /**
     * 채팅방 생성
     */
    @PostMapping("/room")
    @ResponseBody
    public Room createRoom(@RequestParam String name) {
        return chatService.createRoom(name);
    }

    /**
     * 특정 채팅방 조회
     */
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public Room roomInfo(@PathVariable String roomId) {
        return chatService.findRoomById(roomId);
    }
}