package com.example.demo1;

import config.DispatcherServletConfiguration;
import config.MvcConfiguration;
import config.TomcatConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({ TomcatConfiguration.class, DispatcherServletConfiguration.class,
        MvcConfiguration.class })
public class Demo1Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
}
