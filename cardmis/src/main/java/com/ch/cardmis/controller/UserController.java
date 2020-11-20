package com.ch.cardmis.controller;

import com.ch.cardmis.entity.UserEntity;
import com.ch.cardmis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin//跨域访问
    @PostMapping(value = "cardmis/register")
    public String register(@RequestBody UserEntity requestUser) {
        return userService.register(requestUser);
    }

    @CrossOrigin//跨域访问
    @PostMapping(value = "cardmis/login")
    public String login(@RequestBody UserEntity requestUser, HttpSession session) {
        return userService.login(requestUser, session);
    }
}
