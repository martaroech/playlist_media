package com.example.playlist_media.Playlist.Services;

import java.util.List;

import com.example.playlist_media.Playlist.Models.*;

public interface PlaylistService {
    public List<Playlist> getPlaylists();

    public Playlist getPlaylistById(Long id);

    public Playlist createPlaylist(Playlist playlist);

    public void updatePlaylist(Long id, String name);

    public void deletePlaylist(Long id);

    public Playlist addMediaToPlaylist(Long playlistId, Long mediaId);

    public void removeMediaFromPlaylist(Long playlistId, Long mediaId);
}
