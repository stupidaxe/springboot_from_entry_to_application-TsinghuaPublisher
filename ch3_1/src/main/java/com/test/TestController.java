package com.test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
	@RequestMapping("/hello")
	public String hello() {
		return "您好，Spring Boot!";
	}
}    