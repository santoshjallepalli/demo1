package com.example.demo1;

import config.EnableMagicProperties;
import config.MagicApplication;
import config.ServerProperties;
import org.springframework.boot.SpringApplication;

@MagicApplication
@EnableMagicProperties(ServerProperties.class)
public class Demo1Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
}
