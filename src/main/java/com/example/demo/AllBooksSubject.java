package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject implements Subject {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }

    public void attach(SseObserver observer) {
        registerObserver(observer);
    }

    public void detach(SseObserver observer) {
        unregisterObserver(observer);
    }

    public void add(Book book) {
        notifyObservers(book);
    }
}
