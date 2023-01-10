package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyPublisher<Integer> pub1 = new MyPublisher<>(List.of(1,2,3,4,5,6,7,8,9,10));
        MySubscriber<Integer> sub1 = new MySubscriber<>(3);
        pub1.subscribe(sub1);

        System.out.println("--------------------------------------");

        MyPublisher<String> pub2 = new MyPublisher<>(List.of("a","b","c","d","e","f","g","h","i","j"));
        MySubscriber<String> sub2 = new MySubscriber<>(3);
        pub2.subscribe(sub2);
    }
}