package com.ch.ebusiness.service.admin;

import org.springframework.ui.Model;

import com.ch.ebusiness.entity.GoodsType;

public interface TypeService {
	public String selectAllTypeByPage(Model model, int currentPage);
	public String delete(int id);
	public String addType(GoodsType goodsType);
}
