package com.example.demo;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class SseObserver {

    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    public void onNewBook(Book book) {
        try {
            emitter.send(SseEmitter.event()
                    .name("book")
                    .data(book));
        } catch (IOException e) {
            emitter.completeWithError(e);
        }
    }

    public SseEmitter getEmitter() {
        return emitter;
    }
}
