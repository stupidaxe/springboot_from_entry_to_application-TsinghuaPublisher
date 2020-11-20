package com.ch.ch6_6;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//配置扫描MyBatis接口的包路径
@MapperScan(basePackages={"com.ch.ch6_6.repository"})
public class Ch66Application {
	public static void main(String[] args) {
		SpringApplication.run(Ch66Application.class, args);
	}
}
