package com.example.chatapp.src.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatViewController {

    private final ChatService chatService;

    /**
     * 채팅 리스트 화면
     */
    @GetMapping("/room")
    public String rooms(Model model) {
        return "chat/roomlist";
    }


    /**
     * 채팅방 입장 화면
     */
    @GetMapping("/room/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "chat/room";
    }
}
