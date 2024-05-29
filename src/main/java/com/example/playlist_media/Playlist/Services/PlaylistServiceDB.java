package com.example.playlist_media.Playlist.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.playlist_media.Media.Models.*;
import com.example.playlist_media.Media.Services.MediaServiceDB;
import com.example.playlist_media.Playlist.Models.*;
import com.example.playlist_media.Playlist.Repositories.PlaylistRepository;

@Service
public class PlaylistServiceDB implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private MediaServiceDB mediaServiceDB;

    @Transactional(readOnly = true)
    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Playlist getPlaylistById(Long id) {
        return playlistRepository.findById(id).orElseThrow(() -> new RuntimeException("Playlist not found"));
    }

    @Transactional
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Transactional
    public void updatePlaylist(Long id, String name) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlist.setName(name);
        playlistRepository.save(playlist);
    }

    @Transactional
    public void deletePlaylist(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlistRepository.delete(playlist);
    }

    @Transactional
    public Playlist addMediaToPlaylist(Long playlistId, Long mediaId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        Media media = mediaServiceDB.getMediaById(mediaId);
        playlist.getContents().add(media);
        playlistRepository.save(playlist);
        return playlist;
    }

    @Transactional
    public void removeMediaFromPlaylist(Long playlistId, Long mediaId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        Media media = mediaServiceDB.getMediaById(mediaId);
        playlist.getContents().remove(media);
        playlistRepository.save(playlist);
    }
}
