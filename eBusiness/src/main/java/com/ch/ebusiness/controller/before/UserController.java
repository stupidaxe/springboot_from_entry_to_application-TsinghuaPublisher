package com.ch.ebusiness.controller.before;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.ebusiness.entity.BUser;
import com.ch.ebusiness.service.before.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/toRegister")
	public String toRegister(@ModelAttribute("bUser") BUser bUser) {
		return "user/register";
	}
	@RequestMapping("/toLogin")
	public String toLogin(@ModelAttribute("bUser") BUser bUser) {
		//@ModelAttribute("bUser")与th:object="${bUser}"相对应
		return "user/login";
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("bUser") @Validated BUser bUser,
			BindingResult rs, HttpSession session, Model model) {
		if(rs.hasErrors()){//验证失败
	        return "user/login";
	    }
		return userService.login(bUser, session, model);
	}
	@RequestMapping("/isUse")
	@ResponseBody
	public String isUse(@RequestBody BUser bUser) {
		return userService.isUse(bUser);
	}
	@RequestMapping("/register")
	public String register(@ModelAttribute("bUser") @Validated BUser bUser,BindingResult rs) {
		if(rs.hasErrors()){//验证失败
	        return "user/register";
	    }
		return userService.register(bUser);
	}
}
