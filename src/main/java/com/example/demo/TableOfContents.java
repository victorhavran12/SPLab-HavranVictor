package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Column;

@Entity
@DiscriminatorValue("TOC")
public class TableOfContents extends Element {

    @Column(nullable = false)
    private String title;

    public TableOfContents() {
        this(0, "Table of Contents");
    }

    public TableOfContents(String title) {
        this(0, title);
    }

    public TableOfContents(int orderIndex, String title) {
        super(orderIndex);
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
