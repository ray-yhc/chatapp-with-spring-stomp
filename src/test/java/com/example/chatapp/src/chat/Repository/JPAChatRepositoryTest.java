package com.example.chatapp.src.chat.Repository;

import com.example.chatapp.src.chat.model.RoomModel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class JPAChatRepositoryTest {
    @Autowired
    JPAChatRepository chatRepository;

    @Test
    void createRoom () throws Exception {
        //given
        RoomModel room = chatRepository.createRoom("hello");
        //when

        //then
        assertThat(room).isInstanceOf(RoomModel.class);
    }
}