package com.ch.cardmis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CardmisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardmisApplication.class, args);
    }

}
