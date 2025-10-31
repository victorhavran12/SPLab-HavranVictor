package com.example.demo;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Paragraph (align left): " + paragraph.getText());
    }
}
