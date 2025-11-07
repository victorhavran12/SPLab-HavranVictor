package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner seedData(
            BookRepository bookRepository,
            AuthorRepository authorRepository
    ) {
        return args -> {
            Book noapteBuna = new Book("Noapte buna, copii!", "ISBN-00001");
            Author rpGheo = new Author("Radu Pavel", "Gheo");
            authorRepository.save(rpGheo);
            noapteBuna.addAuthor(rpGheo);

            Section cap1   = new Section("Capitolul 1", 1);
            Section cap11  = new Section("Capitolul 1.1", 2);
            Section cap111 = new Section("Capitolul 1.1.1", 3);
            Section cap1111 = new Section("Subchapter: 1.1.1.1", 4);


            Section intro = new Section("Intro", 0);
            intro.addElement(new Paragraph(0, "Multumesc celor care ..."));

            cap1.addElement(new Paragraph(0, "Moto capitol"));

            cap11.addElement(new Paragraph(0, "Text from subchapter 1.1"));
            cap111.addElement(new Paragraph(0, "Text from subchapter 1.1.1"));
            cap1111.addElement(new Image(0, "Image subchapter 1.1.1.1"));

            noapteBuna.addSection(intro);
            noapteBuna.addSection(cap1);
            noapteBuna.addSection(cap11);
            noapteBuna.addSection(cap111);
            noapteBuna.addSection(cap1111);

            bookRepository.save(noapteBuna);

            System.out.println("Saved book: " + noapteBuna.getTitle() + " (id=" + noapteBuna.getId() + ")");
            System.out.println("Authors: " + noapteBuna.getAuthors().size());
            System.out.println("Sections: " + noapteBuna.getSections().size());
            System.out.println("Open H2 console at http://localhost:8080/h2-console");
            System.out.println("JDBC URL: jdbc:h2:file:~/h2db/booksdb  |  user: sa  |  password: (empty)");
        };
    }
}
