package org.example;

public class Main {
    public static void main(String[] args) {
        MyPublisher pub = new MyPublisher();
        MySubscriber sub = new MySubscriber(3);
        pub.subscribe(sub);
    }
}