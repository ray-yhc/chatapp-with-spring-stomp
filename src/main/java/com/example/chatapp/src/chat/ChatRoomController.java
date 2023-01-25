package com.example.chatapp.src.chat;


import com.example.chatapp.src.chat.model.RoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/chat")
public class ChatRoomController {
    private final ChatService chatService;

    @Autowired
    public ChatRoomController(ChatService chatService) {
        this.chatService = chatService;
    }

    /**
     * 모든 채팅방 목록 반환
     */
    @GetMapping("/room")
    @ResponseBody
    public List<RoomModel> room() {
        return chatService.findAllRoom();
    }

    /**
     * 채팅방 생성
     */
    @PostMapping("/room")
    @ResponseBody
    public RoomModel createRoom(@RequestParam String name) {
        return chatService.createRoom(name);
    }

    /**
     * 특정 채팅방 조회
     */
    @GetMapping("/room/{roomCode}")
    @ResponseBody
    public RoomModel roomInfo(@PathVariable String roomCode) {
        return chatService.findRoomByRoomCode(roomCode);
    }
}