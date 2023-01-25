package com.example.chatapp.src.chat;

import com.example.chatapp.src.chat.model.MessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    @Autowired
    public ChatController(SimpMessageSendingOperations simpMessageSendingOperations) {
        this.simpMessageSendingOperations = simpMessageSendingOperations;
    }



    /**
     * /pub/message <br>
     * 메시지 전송시에는 controller에서 처리
     */
    @MessageMapping("/message")
    public void enter(MessageModel messageModel) {
        if (messageModel.getType().equals("ENTER")) {
            messageModel.setMessage(messageModel.getSender()+"님이 입장하였습니다.");
        }

        simpMessageSendingOperations
                .convertAndSend("/topic/room/"+ messageModel.getRoomCode(), messageModel);
    }
}
