package com.example.playlist_media.Media.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.playlist_media.Media.Models.*;
import com.example.playlist_media.Media.Repositories.MediaRepositories;

@Service
public class MediaServiceDB implements MediaService {

    @Autowired
    private MediaRepositories mediaRepositories;
    
    @Transactional(readOnly = true)
    public List<Media> getAllMedia() {
        return mediaRepositories.findAll();
    }

    @Transactional(readOnly = true)
    public Media getMediaById(Long id) {
        return mediaRepositories.findById(id).orElseThrow(() -> new RuntimeException("Media not found"));
    }

    @Transactional
    public Media createMedia(Media media) {
        return mediaRepositories.save(media);
    }

    @Transactional
    public void updateMedia(Long id, String name) {
        Media media = mediaRepositories.findById(id).orElseThrow(() -> new RuntimeException("Media not found"));
        media.setTitle(name);
        mediaRepositories.save(media);
    }

    @Transactional
    public void deleteMedia(Long id) {
        Media media = mediaRepositories.findById(id).orElseThrow(() -> new RuntimeException("Media not found"));
        mediaRepositories.delete(media);
    }

    @Transactional(readOnly = true)
    public Optional<Media> getMediaByPlaylistId(Long id) {
        return mediaRepositories.findById(id);
    }
}
