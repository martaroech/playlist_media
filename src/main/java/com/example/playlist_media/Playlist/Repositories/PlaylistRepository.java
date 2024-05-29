package com.example.playlist_media.Playlist.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.playlist_media.Playlist.Models.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
