package org.example;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.List;

public class MyPublisher implements Publisher<Integer> {

    Iterable<Integer> iterable;

    public MyPublisher() {
        iterable = List.of(1,2,3,4,5,6,7,8,9,10);
    }

    public MyPublisher(Iterable<Integer> iterable) {
        this.iterable = iterable;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        MySubscription subscription = new MySubscription(subscriber, iterable);
        subscriber.onSubscribe(subscription);
    }
}
