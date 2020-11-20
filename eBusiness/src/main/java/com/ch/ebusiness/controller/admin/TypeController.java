package com.ch.ebusiness.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.ebusiness.entity.GoodsType;
import com.ch.ebusiness.service.admin.TypeService;

@Controller
@RequestMapping("/type")
public class TypeController extends AdminBaseController{
	@Autowired
	private TypeService typeService;
	@RequestMapping("/selectAllTypeByPage")
	public String selectAllTypeByPage(Model model, int currentPage) {
		return typeService.selectAllTypeByPage(model, currentPage);
	}
	@RequestMapping("/deleteType")
	@ResponseBody//返回字符串数据而不是视图
	public String delete(int id) {
		return typeService.delete(id);
	}
	@RequestMapping("/toAddType")
	public String toAddType(@ModelAttribute("goodsType") GoodsType goodsType) {
		return "admin/addType";
	}
	@RequestMapping("/addType")
	public String addType(@ModelAttribute("goodsType") GoodsType goodsType) {
		return typeService.addType(goodsType);
	}
}
