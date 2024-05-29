package com.example.playlist_media.Media.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("book")
public class Book extends Media {
    private String genre;
    private int num_pages;

    public Book (String title, String author, String genre, int num_pages) {
        super(title, author);
        this.genre = genre;
        this.num_pages = num_pages;
    }

    public Book () {
    }

    // Metodi getter e setter
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNum_pages() {
        return num_pages;
    }

    public void setNum_pages(int num_pages) {
        this.num_pages = num_pages;
    }
}
