package com.ch.ch4_1.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ValueReaderConfigController {
	@Value("${test.msg}")
    private String msg;
	@RequestMapping("/testValue")
	public String testValue() {
		return "方法二：" + msg;
	}
}
