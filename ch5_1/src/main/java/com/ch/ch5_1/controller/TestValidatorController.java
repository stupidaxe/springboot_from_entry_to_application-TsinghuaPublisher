package com.ch.ch5_1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ch.ch5_1.model.Goods;
@Controller
public class TestValidatorController {
	@RequestMapping("/testValidator")
	public String testValidator(@ModelAttribute("goodsInfo") Goods goods){
		goods.setGname("商品名初始化");
		goods.setGprice(0.0);
	    return "testValidator";
	}
	@RequestMapping(value="/add")
	public String add(@ModelAttribute("goodsInfo") @Validated Goods goods,BindingResult rs){
		//@ModelAttribute("goodsInfo")与th:object="${goodsInfo}"相对应
	    if(rs.hasErrors()){//验证失败
	           return "testValidator";
	       }
	    //验证成功，可以到任意地方，在这里直接到testValidator界面
	    return "testValidator";
	}
}
