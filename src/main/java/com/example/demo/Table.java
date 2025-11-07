package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;

@Entity
@DiscriminatorValue("TABLE_ELEMENT")
public class Table extends Element {

    // keep your original semantic but persist it
    @Lob
    @Column(nullable = false)
    private String something;

    public Table() { }

    public Table(String something) {
        this(0, something);
    }

    public Table(int orderIndex, String something) {
        super(orderIndex);
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("Table: " + something);
    }

    // ----- Getters / Setters -----
    public String getSomething() { return something; }
    public void setSomething(String something) { this.something = something; }
}
