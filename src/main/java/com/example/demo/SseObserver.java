package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class SseObserver implements Observer {

    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }
    @Override
    public void update(Book book) {
        onNewBook(book);
    }

    public void onNewBook(Book book) {
        try {
            emitter.send(
                    SseEmitter.event()
                            .name("book")
                            .data(book, MediaType.APPLICATION_JSON)
            );
        } catch (IOException e) {
            emitter.completeWithError(e);
        }
    }

    public SseEmitter getEmitter() {
        return emitter;
    }
}
