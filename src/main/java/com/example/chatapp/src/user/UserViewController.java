package com.example.chatapp.src.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserViewController {
    private final UserService userService;

    @Autowired
    public UserViewController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 로그인 페이지
     */
    @GetMapping("/home")
    public String home(){
        return "user/login";
    }

    /**
     * 회원가입 페이지
     */
    @GetMapping("/join")
    public String join(){
        return "user/join";
    }

}
