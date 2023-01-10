package com.example.fluxtest.notify;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Component
public class EventNotify {
    private List<String> events = new ArrayList<>();
    private boolean change = false;
    private int index = 0;

    public void add(String data){
        events.add(data + index++);
        change = true;
    }
}
