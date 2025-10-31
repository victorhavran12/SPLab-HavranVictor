package com.example.demo;

public class Paragraph implements Element {
    private String text;
    private AlignStrategy textAlignment; 

    public Paragraph() { }

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

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

    @Override
    public void add(Element e) { }

    @Override
    public void remove(Element e) { }

    @Override
    public Element get(int index) { return null; }
}
