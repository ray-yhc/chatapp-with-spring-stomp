package com.example.chatapp.src.chat;

import com.example.chatapp.src.chat.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/hello")
    public void message(Message message) {
        simpMessageSendingOperations

                .convertAndSend("/sub/channel/" + message.getRoomId(), message);
    }


    @MessageMapping("/chat/message")
    public void enter(Message message) {

        System.out.println((message.getMessage() != null ? message.getMessage() : "null") );

        if (message.getType().equals("ENTER")) {
            message.setMessage(message.getSender()+"님이 입장하였습니다.");
        }

        simpMessageSendingOperations
                .convertAndSend("/topic/chat/room/"+message.getRoomId(),message);
    }
}
