package com.ch.ch6_6.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ch.ch6_6.entity.MyUser;
import com.ch.ch6_6.service.MyUserService;
@RestController
public class MyUserController {
	@Autowired
	private MyUserService myUserService;
	@RequestMapping("/findAll")
	public List<MyUser> findAll(){
		return myUserService.findAll();
	}
}
