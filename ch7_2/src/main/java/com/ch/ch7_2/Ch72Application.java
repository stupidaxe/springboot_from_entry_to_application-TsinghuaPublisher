package com.ch.ch7_2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.ch.ch7_2.repository")
public class Ch72Application {
	public static void main(String[] args) {
		SpringApplication.run(Ch72Application.class, args);
	}
}
