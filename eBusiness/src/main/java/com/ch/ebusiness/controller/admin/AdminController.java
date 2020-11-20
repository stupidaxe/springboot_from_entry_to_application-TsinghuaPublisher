package com.ch.ebusiness.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.ebusiness.entity.AUser;
import com.ch.ebusiness.service.admin.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@RequestMapping("/toLogin")
	public String toLogin(@ModelAttribute("aUser") AUser aUser) {
		return "admin/login";
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("aUser") AUser aUser, HttpSession session, Model model) {
		return adminService.login(aUser, session, model);
	}
}
