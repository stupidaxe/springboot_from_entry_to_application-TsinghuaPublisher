package com.ch.ch4_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ch.spring_boot_mystarters.MyService;
@RestController
@SpringBootApplication
public class Ch42Application {
	@Autowired MyService myService;
	public static void main(String[] args) {
		SpringApplication.run(Ch42Application.class, args);
	}
	@RequestMapping("/testStarters")
	public String index() {
		return myService.sayMsg();
	}
 
}
