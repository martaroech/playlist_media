package com.example.playlist_media.Playlist.Models;

import com.example.playlist_media.Media.Models.*;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera gli ID auto_increment
    private Long id;

    private String name;
    
    @ManyToMany
    @JoinTable(
        name = "Playlist_Media",
        joinColumns = @JoinColumn(name = "id_playlist"),
        inverseJoinColumns = @JoinColumn(name = "id_media")
    )
    private Set<Media> contents = new HashSet<>();
        
    public Playlist (String name, Set<Media> contents) {
        this.name = name;
        this.contents = contents;
    }

    public Playlist () {
    }

    // Metodi getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Media> getContents() {
        return contents;
    }

    public void setContents(Set<Media> contents) {
        this.contents = contents;
    }
}
