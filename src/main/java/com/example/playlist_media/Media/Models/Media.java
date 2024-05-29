package com.example.playlist_media.Media.Models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera gli ID auto_increment
    private Long id;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    private String title;
    private String author;


    public Media (String type, String title, String author) {
        this.type = type;
        this.title = title;
        this.author = author;
    }

    public Media (String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Media () {
    }

    // Metodi getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
