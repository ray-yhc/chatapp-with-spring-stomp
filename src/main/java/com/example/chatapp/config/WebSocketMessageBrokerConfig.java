package com.example.chatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // stomp에서 사용하는 annotaion
public class WebSocketMessageBrokerConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/ws/chat")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }


    /**
     * /topic : 1명 msg 발행 - n명 구독 <br>
     * /queue : 발행한 1명에게 다시 정보를 전송 <br>
     * /put : 발행 시의 uri prefix
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // topic 방식과 queue 방식이 있다.
        registry.enableSimpleBroker("/queue", "/topic");
        registry.setApplicationDestinationPrefixes("/pub");
    }
}