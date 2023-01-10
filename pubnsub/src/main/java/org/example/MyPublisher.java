package org.example;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class MyPublisher <T> implements Publisher<T> {

    Iterable<T> iterable;

    public MyPublisher(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public void subscribe(Subscriber<? super T> subscriber) {
        MySubscription subscription = new MySubscription(subscriber, iterable);
        subscriber.onSubscribe(subscription);
    }
}
