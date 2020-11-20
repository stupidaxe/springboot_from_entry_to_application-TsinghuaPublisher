package com.ch.practice4_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ch.spring_boot_addstarters.AddService;
@RestController
@SpringBootApplication
public class Practice43Application {
	@Autowired AddService addService;
	public static void main(String[] args) {
		SpringApplication.run(Practice43Application.class, args);
	}
	@RequestMapping("/testAddStarters")
	public String index() {
		return addService.add() + "";
	}
}
