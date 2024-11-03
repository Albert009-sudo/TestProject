package com.example.testproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//Run project from here
@EnableWebMvc
@SpringBootApplication
@EntityScan("com.example.testproject.Entity")
public class TestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestProjectApplication.class, args);
    }

}
