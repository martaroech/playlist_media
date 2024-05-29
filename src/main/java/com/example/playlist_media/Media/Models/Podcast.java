package com.example.playlist_media.Media.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("podcast")
public class Podcast extends Media {
    private String genre;
    private int num_episodes;

    public Podcast (String title, String author, String genre, int num_episodes) {
        super(title, author);
        this.genre = genre;
        this.num_episodes = num_episodes;
    }

    public Podcast () {
    }

    // Metodi getter e setter
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNum_episodes() {
        return num_episodes;
    }

    public void setNum_episodes(int num_episodes) {
        this.num_episodes = num_episodes;
    }
}
