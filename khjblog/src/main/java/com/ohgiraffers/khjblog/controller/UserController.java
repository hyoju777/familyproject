package com.ohgiraffers.khjblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/login")
    public String login() {
        return "login"; // login.html 파일을 반환
    }
}
