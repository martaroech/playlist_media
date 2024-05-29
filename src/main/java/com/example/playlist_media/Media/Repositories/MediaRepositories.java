package com.example.playlist_media.Media.Repositories;

import com.example.playlist_media.Media.Models.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepositories extends JpaRepository<Media, Long> {
}
