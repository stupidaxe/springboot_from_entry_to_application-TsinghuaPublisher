package com.ch.ebusiness.service.admin;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.ch.ebusiness.entity.AUser;

public interface AdminService {
	public String login(AUser aUser, HttpSession session, Model model);
}
