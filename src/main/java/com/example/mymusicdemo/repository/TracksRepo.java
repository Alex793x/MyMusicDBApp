package com.example.mymusicdemo.repository;

import com.example.mymusicdemo.model.Albums;
import com.example.mymusicdemo.model.Tracks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TracksRepo {

    @Autowired
    JdbcTemplate template;

    public List<Tracks> fetchAll() {
        String sql = "SELECT tracks.* FROM tracks ORDER BY title";
        return template.query(sql, new BeanPropertyRowMapper<>(Tracks.class));
    }

    public List<Tracks> fetch_all_fk_artist(int fk_id) {
        String sql = "SELECT DISTINCT tracks.* FROM tracks " +
                "JOIN albums USING (albums_id) " +
                "JOIN artists USING (artists_id) " +
                "WHERE albums.artists_id = " + fk_id;
        return template.query(sql, new BeanPropertyRowMapper<>(Tracks.class));
    }

    public List<Tracks> fetch_all_fk_albums(int fk_id) {
        String sql = "SELECT tracks.* FROM tracks " +
                "JOIN albums USING (albums_id) " +
                "WHERE albums.albums_id = " + fk_id;
        return template.query(sql, new BeanPropertyRowMapper<>(Tracks.class));
    }

    public void addTracks(Tracks tracks) {
        String sql = "INSERT INTO tracks (title, duration, albums_id) VALUES (?, ? , ?)";
        template.update(sql,
                tracks.getTitle(),
                tracks.getDuration(),
                tracks.getAlbums_id());
    }

    public void incrementAlbumSongs(Tracks tracks) {
        String sql = "UPDATE albums SET amount = amount + 1 WHERE albums_id = ?";
        template.update(sql, tracks.getAlbums_id());
    }
}
