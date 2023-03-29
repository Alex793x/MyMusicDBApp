package com.example.mymusicdemo.service;

import com.example.mymusicdemo.model.Tracks;
import com.example.mymusicdemo.repository.TracksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TracksService {

    @Autowired
    TracksRepo tracksRepo;


    public List<Tracks> fetchAll() {
        return tracksRepo.fetchAll();
    }

    public List<Tracks> fetch_fk_all_artists(int fk_id) {
        return tracksRepo.fetch_all_fk_artist(fk_id);
    }

    public List<Tracks> fetch_all_fk_albums(int id) {
        return tracksRepo.fetch_all_fk_albums(id);
    }

    public void addTracks(Tracks tracks) {
        tracksRepo.addTracks(tracks);
        tracksRepo.incrementAlbumSongs(tracks);
    }
}
