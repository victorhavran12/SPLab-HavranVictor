package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Lob;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;

@Entity
@DiscriminatorValue("PARAGRAPH")
public class Paragraph extends Element {

    @Lob
    @Column(nullable = false)
    private String text;

    @Transient
    private AlignStrategy textAlignment;

    public Paragraph() { }

    public Paragraph(String text) {
        this(0, text);
    }

    public Paragraph(int orderIndex, String text) {
        super(orderIndex);
        this.text = text;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public void setAlignStrategy(AlignStrategy strategy) {
        this.textAlignment = strategy;
    }

    @Override
    public void print() {
        if (textAlignment != null) {
            textAlignment.render(this);
        } else {
            System.out.println("Paragraph: " + text);
        }
    }
}
