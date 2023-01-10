package org.example;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

public class MySubscription implements Subscription {
    private final Subscriber subscriber;
    private final Iterator<Integer> iterator;

    public MySubscription(Subscriber subscriber, Iterable iterator) {
        this.subscriber = subscriber;
        this.iterator = iterator.iterator();
        System.out.println("Subscription Created");
    }

    @Override
    public void request(long n) {
        while (n > 0){
            if (iterator.hasNext()){
                subscriber.onNext(iterator.next());
            } else {
                subscriber.onComplete();
                break;
            }
            n--;
        }
    }

    @Override
    public void cancel() {

    }
}
