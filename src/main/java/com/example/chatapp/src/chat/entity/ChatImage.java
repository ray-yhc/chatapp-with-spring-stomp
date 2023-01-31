package com.example.chatapp.src.chat.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity @Data
public class ChatImage extends Chat{
    private String ImageUrl;
}
