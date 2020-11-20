package com.ch.ebusiness.controller.admin;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.ch.ebusiness.NoLoginException;
@Controller
public class AdminBaseController {
	/**
	 * 登录权限控制，处理方法执行前执行该方法 
	 */
	@ModelAttribute  
    public void isLogin(HttpSession session) throws NoLoginException {      
       if(session.getAttribute("auser") == null){  
            throw new NoLoginException("没有登录");
       }  
    } 
}