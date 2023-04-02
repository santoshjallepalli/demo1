package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class Demo1Application {

    @Bean
    EmbeddedServletContainerFactory servletContainerFactory() {
        return new TomcatEmbeddedServletContainerFactory();
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @RestController
    class HelloController {

        @RequestMapping("/")
        public String hello() {
            return "Hello World";
        }

    }


}
