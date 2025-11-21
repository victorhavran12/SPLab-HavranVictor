package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    private final BooksRepository booksRepository;
    private final CreateBookCommand createBookCommand;
    private final AllBooksSubject allBooksSubject;

    public BooksController(BooksRepository booksRepository,
                           CreateBookCommand createBookCommand,
                           AllBooksSubject allBooksSubject) {
        this.booksRepository = booksRepository;
        this.createBookCommand = createBookCommand;
        this.allBooksSubject = allBooksSubject;
    }

    @PostMapping("/books")
    public String newBook(@RequestBody NewBookRequest newBookRequest) {
        CommandContext context = new CommandContext(booksRepository);
        Book savedBook = createBookCommand.execute(context, newBookRequest);

        allBooksSubject.add(savedBook);

        return "Book saved [" + savedBook.getId() + "] " + savedBook.getTitle();
    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return booksRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id) {
        return booksRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> update(
            @PathVariable Integer id,
            @RequestBody NewBookRequest newBookRequest) {

        return booksRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(newBookRequest.getTitle());
                    Book updated = booksRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!booksRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        booksRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
