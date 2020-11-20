package com.ch.ebusiness;
import java.sql.SQLException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * 统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandleController {
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		String message = "";
		//数据库异常
		if (e instanceof SQLException) {
			message = "数据库异常";
		} else if (e instanceof NoLoginException) {
			message = "未登录异常";
		} else {//未知异常
			message =  "未知异常";
		}
		model.addAttribute("mymessage",message);
		return "myError";
	}
}