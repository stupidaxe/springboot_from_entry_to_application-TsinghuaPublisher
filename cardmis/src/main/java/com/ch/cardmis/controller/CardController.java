package com.ch.cardmis.controller;

import com.ch.cardmis.entity.CardEntity;
import com.ch.cardmis.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@RestController
public class CardController {
    @Autowired
    private CardService cardService;
    @CrossOrigin//跨域访问
    @PostMapping(value = "cardmis/add")
    public String add(CardEntity cardEntity, HttpSession session, MultipartFile file) {
        return cardService.add(cardEntity, session, file);
    }
    @CrossOrigin//跨域访问
    @GetMapping(value = "cardmis/cards")
    public Object cards(HttpSession session) {
        return cardService.cards(session);
    }
    @CrossOrigin//跨域访问
    @PostMapping(value = "cardmis/delete")
    public String delete(HttpSession session,Integer cid) {
        return cardService.delete(session,cid);
    }
    @CrossOrigin//跨域访问
    @GetMapping(value = "cardmis/aCard")
    public Object aCard(HttpSession session,Integer cid) {
        return cardService.aCard(session,cid);
    }
}
