package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyPublisher pub = new MyPublisher(List.of(1,2,3,4,5,6,7,8,9,10));
        MySubscriber sub = new MySubscriber(3);
        pub.subscribe(sub);
    }
}