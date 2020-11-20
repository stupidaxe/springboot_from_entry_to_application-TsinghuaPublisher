package com.ch.ch5_3.controller;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.ch5_3.exception.MyException;
@Controller
public class TestHandleExceptionController{
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/db")  
    public void db() throws SQLException { 
        throw new SQLException("数据库异常");
    }  
	@RequestMapping("/my")  
    public void my() throws MyException {  
        throw new MyException("自定义异常");
    }
	@RequestMapping("/no")  
    public void no() throws Exception {  
        throw new Exception("未知异常");
    } 
	
}
