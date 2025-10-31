package com.example.demo;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Paragraph (align center): " + paragraph.getText());
    }
}
