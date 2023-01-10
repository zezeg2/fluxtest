package com.example.fluxtest.filters;

import com.example.fluxtest.notify.EventNotify;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

    @Autowired
    private EventNotify eventNotify;
    @Bean
    public FilterRegistrationBean<Filter> addFilter1(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilter1(eventNotify));
        bean.addUrlPatterns("/sse");
        System.out.println("My Filter1 enrolled");
        return bean;
    }

    @Bean
    public FilterRegistrationBean<Filter> addFilter2(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilter2(eventNotify));
        bean.addUrlPatterns("/sse/add");
        System.out.println("My Filter2 enrolled");
        return bean;
    }
}
