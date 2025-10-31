package com.example.demo;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Paragraph (align right): " + paragraph.getText());
    }
}
