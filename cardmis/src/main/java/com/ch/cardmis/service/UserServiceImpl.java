package com.ch.cardmis.service;
import com.ch.cardmis.entity.UserEntity;
import com.ch.cardmis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public String register(UserEntity requestUser) {
        UserEntity ue = userRepository.findByUname(requestUser.getUname());
        if(ue != null)
            return "no";
        else{
            userRepository.save(requestUser);
            return "yes";
        }
    }
    @Override
    public String login(UserEntity requestUser, HttpSession session) {
        UserEntity ue = userRepository.findByUnameAndUpwd(requestUser.getUname(), requestUser.getUpwd());
        if(ue != null){//登录成功
            session.setAttribute("user", ue);
            return "ok";
        }
        return "no";
    }
}
