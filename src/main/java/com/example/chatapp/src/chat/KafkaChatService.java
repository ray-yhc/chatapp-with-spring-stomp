package com.example.chatapp.src.chat;

import com.example.chatapp.src.chat.model.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class KafkaChatService {
    private KafkaTemplate<String, MessageModel> kafkaTemplate;
    private SimpMessageSendingOperations simpMessageSendingOperations;
    private final ChatService chatService;
    private final String TOPIC_NAME = "chat";
    private final String CONSUMER_GROUP_ID = "localhost-1";
    private final String DB_GROUP_ID = "DB-1";

    @Autowired
    public KafkaChatService(KafkaTemplate<String, MessageModel> kafkaTemplate, SimpMessageSendingOperations simpMessageSendingOperations, ChatService chatService) {
        this.kafkaTemplate = kafkaTemplate;
        this.simpMessageSendingOperations = simpMessageSendingOperations;
        this.chatService = chatService;
    }


    public void send(MessageModel content) {
        kafkaTemplate.send(TOPIC_NAME, content);
    }

    @KafkaListener(groupId = CONSUMER_GROUP_ID,topics = TOPIC_NAME)
    public void receive(MessageModel messageModel) {
        simpMessageSendingOperations
                .convertAndSend("/topic/room/"+ messageModel.getRoomCode(), messageModel);

    }

    @KafkaListener(groupId = DB_GROUP_ID ,topics = TOPIC_NAME)
    public void receiveDB(MessageModel messageModel) {
        chatService.addChat(messageModel);
    }
}
