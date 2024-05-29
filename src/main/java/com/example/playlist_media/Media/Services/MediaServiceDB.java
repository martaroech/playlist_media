package com.example.playlist_media.Media.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    public List<Media> getAllMedia() {
        return mediaRepositories.findAll();
    }

    public Media getMediaById(Long id) {
        return mediaRepositories.findById(id).orElseThrow(() -> new RuntimeException("Media not found"));
    }

    public Media createMedia(Media media) {
        return mediaRepositories.save(media);
    }

    public void updateMedia(Long id, String name) {
        Media media = mediaRepositories.findById(id).orElseThrow(() -> new RuntimeException("Media not found"));
        media.setTitle(name);
        mediaRepositories.save(media);
    }

    public void deleteMedia(Long id) {
        Media media = mediaRepositories.findById(id).orElseThrow(() -> new RuntimeException("Media not found"));
        mediaRepositories.delete(media);
    }

    public Optional<Media> getMediaByPlaylistId(Long id) {
        return mediaRepositories.findById(id);
    }

    public Media addMediaToPlaylist(Long playlistId, Long mediaId) {
        Media media = mediaRepositories.findById(mediaId).orElseThrow(() -> new RuntimeException("Media not found"));
        Playlist playlist = playlistServiceDB.getPlaylistById(playlistId);
        playlist.getContents().add(media);
        playlistRepository.save(playlist);
        return media;
    }

    public void removeMediaFromPlaylist(Long playlistId, Long mediaId) {
        Media media = mediaRepositories.findById(mediaId).orElseThrow(() -> new RuntimeException("Media not found"));
        Playlist playlist = playlistServiceDB.getPlaylistById(playlistId);
        playlist.getContents().remove(media);
        playlistRepository.save(playlist);
    }
}
