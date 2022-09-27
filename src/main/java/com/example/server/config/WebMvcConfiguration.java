package com.example.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@ComponentScan("com.example.server")
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    // ...

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/api/login").setViewName("login/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}