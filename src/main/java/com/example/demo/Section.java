package com.example.demo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private int position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("orderIndex ASC, id ASC")
    private List<Element> elements = new ArrayList<>();

    public Section() { }

    public Section(String title) {
        this.title = title;
    }

    public Section(String title, int position) {
        this.title = title;
        this.position = position;
    }

    public void addElement(Element e) {
        if (e == null) return;
        e.setSection(this);
        elements.add(e);
    }

    public void removeElement(Element e) {
        if (e == null) return;
        e.setSection(null);
        elements.remove(e);
    }
    
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements.clear();
        if (elements != null) {
            for (Element e : elements) addElement(e);
        }
    }
}
