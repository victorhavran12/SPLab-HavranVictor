package com.example.demo;

import jakarta.persistence.*;

/**
 * Base JPA entity for all content elements inside a Section.
 * Uses SINGLE_TABLE inheritance for simplicity (you can switch to JOINED later).
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_index")
    private int orderIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private Section section;

    protected Element() { }

    protected Element(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public abstract void print();

    public Long getId() { return id; }

    public int getOrderIndex() { return orderIndex; }
    public void setOrderIndex(int orderIndex) { this.orderIndex = orderIndex; }

    public Section getSection() { return section; }
    public void setSection(Section section) { this.section = section; }
}
