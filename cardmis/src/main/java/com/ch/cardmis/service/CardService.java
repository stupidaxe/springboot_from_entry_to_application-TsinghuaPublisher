package com.ch.cardmis.service;

import com.ch.cardmis.entity.CardEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

public interface CardService {
    public String add(CardEntity cardEntity, HttpSession session, MultipartFile file);
    public String isLogin(HttpSession session);
    public Object cards(HttpSession session);
    public String delete(HttpSession session,Integer cid);
    public Object aCard(HttpSession session,Integer cid);
}
