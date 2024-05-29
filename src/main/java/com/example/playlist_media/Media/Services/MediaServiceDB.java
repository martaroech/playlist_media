package com.example.playlist_media.Media.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.playlist_media.Media.Models.*;
import com.example.playlist_media.Media.Repositories.MediaRepositories;
import com.example.playlist_media.Playlist.Models.Playlist;
import com.example.playlist_media.Playlist.Repositories.PlaylistRepository;
import com.example.playlist_media.Playlist.Services.PlaylistServiceDB;

@Service
public class MediaServiceDB implements MediaService {

    @Autowired
    private MediaRepositories mediaRepositories;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private PlaylistServiceDB playlistServiceDB;
    
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

    @Transactional
    public Media addMediaToPlaylist(Long playlistId, Long mediaId) {
        Media media = mediaRepositories.findById(mediaId).orElseThrow(() -> new RuntimeException("Media not found"));
        Playlist playlist = playlistServiceDB.getPlaylistById(playlistId);
        playlist.getContents().add(media);
        playlistRepository.save(playlist);
        return media;
    }

    @Transactional
    public void removeMediaFromPlaylist(Long playlistId, Long mediaId) {
        Media media = mediaRepositories.findById(mediaId).orElseThrow(() -> new RuntimeException("Media not found"));
        Playlist playlist = playlistServiceDB.getPlaylistById(playlistId);
        playlist.getContents().remove(media);
        playlistRepository.save(playlist);
    }
}
