package com.example.chatapp.src.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
@RequestMapping("/app/user")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    /**
     * 로그인 요청
     * [POST] /app/user/
     */
//    @PostMapping
//    public PostLoginRes login (@RequestBody PostLoginReq request){
//        // form validation
//        if(request.getId().isEmpty()){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id를 입력해주세요");
//        }
//
//        try {
//            PostLoginRes postLoginRes = userService.logIn(request);
//            return new BaseResponse<>(postLoginRes);
//        } catch (BaseException exception) {
//            return new BaseResponse<>(exception.getStatus());
//        }
//    }



    /**
     * 회원가입 요청
     * [POST] /app/user/new
     */
//    @PostMapping




}
