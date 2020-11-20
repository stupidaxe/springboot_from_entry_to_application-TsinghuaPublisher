package com.ch.ch6_10;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching
@SpringBootApplication
public class Ch610Application {
	public static void main(String[] args) {
		SpringApplication.run(Ch610Application.class, args);
	}
}
