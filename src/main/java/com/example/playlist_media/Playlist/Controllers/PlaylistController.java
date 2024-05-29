package com.example.playlist_media.Playlist.Controllers;

import com.example.playlist_media.Playlist.Models.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.playlist_media.Playlist.Services.PlaylistServiceDB;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistServiceDB playlistService;

    /* Azioni su playlist */
    // Get su tutte le playlist
    @GetMapping("/get/all")
    public List<Playlist> getPlaylists() {
        return playlistService.getPlaylists();
    }

    // Get su una playlist tramite l'id
    @GetMapping("/get/{id}")
    public Playlist getPlaylistById(@PathVariable Long id) {
        return playlistService.getPlaylistById(id);
    }

    // Post per creare una playlist
    @PostMapping("/create")
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    // Put per modificare il nome di una playlist
    @PutMapping("/put/{id}/name")
    public void updatePlaylist(@PathVariable Long id, @RequestBody String name) {
        playlistService.updatePlaylist(id, name);
    }

    // Delete per eliminare una playlist
    @DeleteMapping("/delete/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
    }

    /* Azioni su media */
    // Post per aggiungere un media a una playlist
    @PostMapping("/{playlist_id}/addMedia/{media_id}")
    public Playlist addMediaToPlaylist(@PathVariable Long playlist_id, @PathVariable Long media_id) {
        return playlistService.addMediaToPlaylist(playlist_id, media_id);
    }

    // Delete per rimuovere un media da una playlist
    @DeleteMapping("/{playlist_id}/removeMedia/{media_id}")
    public void removeMediaFromPlaylist(@PathVariable Long playlist_id, @PathVariable Long media_id) {
        playlistService.removeMediaFromPlaylist(playlist_id, media_id);
    }
}
