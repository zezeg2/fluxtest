package com.example.fluxtest.filters;

import com.example.fluxtest.notify.EventNotify;
import jakarta.servlet.*;
import lombok.SneakyThrows;

import java.io.IOException;


public class MyFilter2 implements Filter {
    private EventNotify notify;


    public MyFilter2(EventNotify notify) {
        this.notify = notify;
    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("My Filter2 run");

        notify.add("new data");
    }
}
