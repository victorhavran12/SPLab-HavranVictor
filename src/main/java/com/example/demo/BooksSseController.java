package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;
    private final BooksRepository booksRepository;

    public BooksSseController(AllBooksSubject allBooksSubject, BooksRepository booksRepository) {
        this.allBooksSubject = allBooksSubject;
        this.booksRepository = booksRepository;
    }

    @GetMapping(value = "/books-sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(60000L);
        final SseObserver observer = new SseObserver(emitter);
        allBooksSubject.attach(observer);

        // Send all existing books to the client
        try {
            for (Book book : booksRepository.findAll()) {
                observer.update(book);
            }
        } catch (Exception e) {
            allBooksSubject.detach(observer);
        }

        emitter.onCompletion(() -> allBooksSubject.detach(observer));
        emitter.onTimeout(() -> allBooksSubject.detach(observer));
        emitter.onError(e -> allBooksSubject.detach(observer));

        return emitter;
    }
}
