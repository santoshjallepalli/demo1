package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class Demo1Application {

    @Bean
    EmbeddedServletContainerFactory servletContainerFactory() {
        return new TomcatEmbeddedServletContainerFactory();
    }

    @Bean
    DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
}
