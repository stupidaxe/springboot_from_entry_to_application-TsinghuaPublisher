package com.ch.ch5_3.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ch.ch5_3.exception.MyException;

public class BaseController {
	@ExceptionHandler(value=Exception.class)
	public String handlerException(Exception e) {
		//数据库异常
		if (e instanceof SQLException) {
			return "sqlError";
		} else if (e instanceof MyException) {//自定义异常
			return "myError";
		} else {//未知异常
			return "noError";
		}
	}
}
