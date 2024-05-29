package com.example.playlist_media.Media.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("Podcast")
public class Podcast extends Media {
    private String topic;
    private int numEpisodes;

    public Podcast (String title, String author, String topic, int numEpisodes) {
        super(title, author);
        this.topic = topic;
        this.numEpisodes = numEpisodes;
    }

    public Podcast () {
    }

    // Metodi getter e setter
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getNumEpisodes() {
        return numEpisodes;
    }

    public void setNumEpisodes(int numEpisodes) {
        this.numEpisodes = numEpisodes;
    }
}
