package com.example.mymusicdemo.service;

import com.example.mymusicdemo.model.Artists;
import com.example.mymusicdemo.repository.ArtistsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistsService {

    @Autowired
    ArtistsRepo artistsRepo;

    public List<Artists> fetchAll() {
        return artistsRepo.fetchAll();
    }

    public void addArtist(Artists artists) {
        artistsRepo.addArtist(artists);
    }
}
