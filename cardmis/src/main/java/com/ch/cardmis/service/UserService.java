package com.ch.cardmis.service;

import com.ch.cardmis.entity.UserEntity;

import javax.servlet.http.HttpSession;

public interface UserService {
    public String register(UserEntity requestUser);
    public String login(UserEntity requestUser, HttpSession session);
}
