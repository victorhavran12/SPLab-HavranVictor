package com.example.demo;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new LinkedHashSet<>();

    public Author() { }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void print() {
        System.out.println("Author: " + name + " " + surname);
    }

    public Long getId() { return id; } 

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public Set<Book> getBooks() { return books; }
    public void setBooks(Set<Book> books) {
        this.books = (books == null) ? new LinkedHashSet<>() : books;
    }
}
