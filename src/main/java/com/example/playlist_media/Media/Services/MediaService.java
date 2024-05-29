package com.example.playlist_media.Media.Services;

import java.util.List;

import com.example.playlist_media.Media.Models.Media;

public interface MediaService {
    public List<Media> getAllMedia();

    public Media getMediaById(Long id);

    public Media createMedia(Media media);

    public void updateMedia(Long id, String name);

    public void deleteMedia(Long id);

    public Media addMediaToPlaylist(Long playlist_id, Long media_id);

    public void removeMediaFromPlaylist(Long playlist_id, Long media_id);
}
