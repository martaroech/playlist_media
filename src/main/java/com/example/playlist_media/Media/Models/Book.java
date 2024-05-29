package com.example.playlist_media.Media.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
public class Book extends Media {
    private String genre;
    private int numPages;

    public Book (String title, String author, String genre, int numPages) {
        super(title, author);
        this.genre = genre;
        this.numPages = numPages;
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

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
}
