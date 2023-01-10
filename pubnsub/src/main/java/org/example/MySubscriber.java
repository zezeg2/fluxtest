package org.example;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySubscriber<T> implements Subscriber<T> {

    private final int backPressure;
    private int bufferSize;
    private Subscription subscription;

    public MySubscriber(int backPressure) {
        System.out.println("Subscriber Created");
        System.out.println("Backpressure : " + backPressure);
        this.backPressure = backPressure;
        bufferSize = backPressure;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        System.out.println("Subscriber initialize Subscription");
        this.subscription.request(backPressure);
    }

    @Override
    public void onNext(T data) {
        System.out.println("onNext() : " + data);
        bufferSize--;
        if (bufferSize == 0) {
            System.out.println("Buffer Cleared\n");
            bufferSize = backPressure;
            subscription.request(backPressure);
        }

    }

    @Override
    public void onError(Throwable t) {
        System.out.println("Exception Invoked on Subscription");
    }

    @Override
    public void onComplete() {
        System.out.println("Complete Subscription");
    }
}
