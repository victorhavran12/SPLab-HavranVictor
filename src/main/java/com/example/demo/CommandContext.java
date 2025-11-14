package com.example.demo;

public class CommandContext {

    private final BooksRepository booksRepository;

    public CommandContext(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public BooksRepository getBooksRepository() {
        return booksRepository;
    }
}
