package com.example.playlist_media.Media.Controller;

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

import com.example.playlist_media.Media.Models.*;
import com.example.playlist_media.Media.Services.MediaServiceDB;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaServiceDB mediaService;

    /* Azioni su media */
    // Get su tutti i media
    @GetMapping("/get/all")
    public List<Media> getAllMedia() {
        return mediaService.getAllMedia();
    }

    // Get su un media tramite l'id
    @GetMapping("/get/{id}")
    public Media getMediaById(@PathVariable Long id) {
        return mediaService.getMediaById(id);
    }

    // Post per creare un media
    @PostMapping("/create")
    public Media createMedia(@RequestBody Media media) {
        return mediaService.createMedia(media);
    }

    // Put per modificare il nome di un media
    @PutMapping("/put/{id}/name")
    public void updateMedia(@PathVariable Long id, @RequestBody String name) {
        mediaService.updateMedia(id, name);
    }

    // Delete per eliminare un media
    @DeleteMapping("/delete/{id}")
    public void deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
    }

    /* Azioni su playlist */
    // Post per aggiungere un media ad una playlist
    @PostMapping("/add/{mediaId}/{playlistId}")
    public void addMediaToPlaylist(@PathVariable Long media_id, @PathVariable Long playlist_id) {
        mediaService.addMediaToPlaylist(media_id, playlist_id);
    }

    // Delete per rimuovere un media da una playlist
    @DeleteMapping("/remove/{mediaId/{playlistId}")
    public void removeMediaFromPlaylist(@PathVariable Long media_id, @PathVariable Long playlist_id) {
        mediaService.removeMediaFromPlaylist(media_id, playlist_id);
    }
}
