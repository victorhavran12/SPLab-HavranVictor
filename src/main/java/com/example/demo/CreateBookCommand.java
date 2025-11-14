package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class CreateBookCommand {

    public Book execute(CommandContext context, NewBookRequest request) {
        Book book = createBook(request);
        return context.getBooksRepository().save(book);
    }

    private Book createBook(NewBookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        return book;
    }
}
