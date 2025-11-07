package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OrderBy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@jakarta.persistence.Table(name = "book") 
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, length = 20)
    private String isbn;

    @ManyToMany
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("position ASC, id ASC")
    private List<Section> sections = new ArrayList<>();

    public Book() {}

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public void addAuthor(Author a) {
        if (a == null) return;
        authors.add(a);
        a.getBooks().add(this);
    }

    public void removeAuthor(Author a) {
        if (a == null) return;
        authors.remove(a);
        a.getBooks().remove(this);
    }

    public void addSection(Section s) {
        if (s == null) return;
        s.setBook(this);
        sections.add(s);
    }

    public void removeSection(Section s) {
        if (s == null) return;
        s.setBook(null);
        sections.remove(s);
    }


    public Long getId() { return id; } 

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Set<Author> getAuthors() { return authors; }
    public void setAuthors(Set<Author> authors) {
        this.authors = (authors == null) ? new LinkedHashSet<>() : authors;
    }

    public List<Section> getSections() { return sections; }
    public void setSections(List<Section> sections) {
        this.sections.clear();
        if (sections != null) {
            for (Section s : sections) addSection(s);
        }
    }
}
