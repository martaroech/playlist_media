package com.example.playlist_media.Media.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Song")
public class Song extends Media {
    private String genre;
    private double duration;

    public Song (String title, String author, String genre, double duration) {
        super(title, author);
        this.genre = genre;
        this.duration = duration;
    }

    public Song () {
    }

    // Metodi getter e setter
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
