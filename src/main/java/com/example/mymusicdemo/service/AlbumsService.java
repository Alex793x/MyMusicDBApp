package com.example.mymusicdemo.service;

import com.example.mymusicdemo.model.Albums;
import com.example.mymusicdemo.repository.AlbumsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumsService {

    @Autowired
    AlbumsRepo albumsRepo;

    public List<Albums> fetchAll() {
        return albumsRepo.fetchAll();
    }

    public List<Albums> fetch_fk_all_artist(int fk_id) {
        return albumsRepo.fetch_fk_all_artist(fk_id);
    }

    public void addAlbums(Albums albums) {
        albumsRepo.addAlbums(albums);
    }

    public void deleteAlbum(int fk_id) {
        albumsRepo.deleteAlbum(fk_id);
    }

    public Albums findAlbumById(int id) {
        return albumsRepo.findAlbumById(id);
    }
}
