package org.example;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

public class MySubscription<T> implements Subscription {
    private final Subscriber<? super T> subscriber;
    private final Iterator<T> iterator;

    public MySubscription(Subscriber<? super T> subscriber, Iterable<T> iterable) {
        this.subscriber = subscriber;
        this.iterator = iterable.iterator();
        System.out.println("Subscription Created");
    }

    @Override
    public void request(long n) {
        while (n > 0){
            if (iterator.hasNext()) subscriber.onNext(iterator.next());
            else {
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
