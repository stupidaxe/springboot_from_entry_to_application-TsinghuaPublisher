package com.ch.practice5_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.practice5_1.model.MyUser;

@Controller
public class UserController {
	@RequestMapping("/")
	public String input(@ModelAttribute("myUser") MyUser mu) {
		//@ModelAttribute("myUser")与th:object="${myUser}"相对应
		return "input";
	}
	@RequestMapping("/add")
	public String add( @ModelAttribute("myUser") @Validated MyUser mu,BindingResult rs) {
		//@ModelAttribute("myUser")与th:object="${myUser}"相对应
		 if(rs.hasErrors()){//验证失败
	           return "input";
	     }
	    //验证成功
	    return "success";
	}
}
