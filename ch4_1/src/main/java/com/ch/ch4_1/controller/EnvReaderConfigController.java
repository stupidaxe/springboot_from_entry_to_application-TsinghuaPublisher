package com.ch.ch4_1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EnvReaderConfigController {
	@Autowired 
	private Environment env;
	@RequestMapping("/testEnv")
	public String testEnv() {
		return "方法一：" + env.getProperty("test.msg") ;
	}
}
