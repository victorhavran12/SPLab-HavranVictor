package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import java.awt.image.BufferedImage;

@Entity
@DiscriminatorValue("IMAGE")
public class Image extends Element {

    @Column(nullable = false)
    private String url;

    @Transient
    private BufferedImage realImage;

    public Image() { }

    public Image(int orderIndex, String url) {
        super(orderIndex);
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + url);
    }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public BufferedImage getRealImage() { return realImage; }
    public void setRealImage(BufferedImage realImage) { this.realImage = realImage; }
}
