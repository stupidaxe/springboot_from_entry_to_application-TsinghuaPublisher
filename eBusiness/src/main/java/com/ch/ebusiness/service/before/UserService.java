package com.ch.ebusiness.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.ch.ebusiness.entity.BUser;

public interface UserService {
	public String isUse(BUser bUser);
	public String register(BUser bUser);
	public String login(BUser bUser, HttpSession session, Model model);
}
