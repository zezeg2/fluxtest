package com.example.fluxtest.filters;

import com.example.fluxtest.notify.EventNotify;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PrintWriter;


public class MyFilter1 implements Filter {
    private EventNotify notify;

    public MyFilter1(EventNotify notify) {
        this.notify = notify;
    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("My Filter1 run");

        HttpServletResponse servletResponse = (HttpServletResponse) response;
//        servletResponse.setContentType("text/plain:charset=utf-8");
        servletResponse.setContentType("text/event-stream:charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(500);
            writer.println("Response : " + i + "\n");
            writer.flush();
        }

        while (true) {
            if (notify.isChange()) {
                writer.println(notify.getEvents().get(notify.getIndex() - 1) + "\n");
                writer.flush();
                notify.setChange(false);
            }
            Thread.sleep(10);
        }
    }
}
