package com.ch.ch9_1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestDevToolsController {
	@RequestMapping("/testDevTools")
	public String testDevTools() {
		return "test DevTools 222";
	}
}
