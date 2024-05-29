package com.example.playlist_media.Media.Services;

import java.util.List;

import com.example.playlist_media.Media.Models.*;

public interface MediaService {
    public List<Media> getAllMedia();

    public Media getMediaById(Long id);

    public Song createSong(Song song);

    public Book createBook(Book book);

    public Podcast createPodcast(Podcast podcast);

    public void updateMedia(Long id, String name);

    public void deleteMedia(Long id);
}
