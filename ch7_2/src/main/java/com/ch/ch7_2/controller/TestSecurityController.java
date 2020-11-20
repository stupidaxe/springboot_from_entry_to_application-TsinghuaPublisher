package com.ch.ch7_2.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ch.ch7_2.entity.MyUser;
import com.ch.ch7_2.service.UserService;
@Controller
public class TestSecurityController {
	@Autowired
	private UserService userService;
	@RequestMapping("/")
	public String index() {
		return "/index";
	}
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "/login";
	}
	@RequestMapping("/toRegister")
	public String toRegister(@ModelAttribute("userDomain") MyUser userDomain) {
		return "/register";
	}
	@RequestMapping("/register")
	public String register(@ModelAttribute("userDomain") MyUser userDomain) {
		return userService.register(userDomain);
	}
	@RequestMapping("/login")
	public String login() {
		//这里什么都不错，由Spring Security负责登录验证
		return "/login";
	}
	@RequestMapping("/user/loginSuccess")
	public String loginSuccess(Model model) {
		return userService.loginSuccess(model);
	}
	@RequestMapping("/admin/main")
	public String main(Model model) {
		return userService.main(model);
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		return userService.logout(request, response);
	}
	@RequestMapping("/deniedAccess")
	public String deniedAccess(Model model) {
		return userService.deniedAccess(model);
	}
}
