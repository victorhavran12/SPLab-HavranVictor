package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject {

    private final List<SseObserver> observers = new CopyOnWriteArrayList<>();

    public void attach(SseObserver observer) {
        observers.add(observer);
    }

    public void detach(SseObserver observer) {
        observers.remove(observer);
    }

    public void add(Book book) {
        for (SseObserver observer : observers) {
            observer.onNewBook(book);
        }
    }
}
