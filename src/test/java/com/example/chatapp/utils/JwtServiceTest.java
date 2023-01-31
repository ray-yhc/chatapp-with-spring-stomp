package com.example.chatapp.utils;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class JwtServiceTest {

    @Autowired
    JwtService jwtService;

    @Test
    void createJwt() throws Exception {
        //given
        long id = 123L;
        String jws = jwtService.createJwt(id);

        //when
        long parsedId = jwtService.parseUserIdx(jws);

        //then
        assertThat(parsedId).isEqualTo(id);
    }

}