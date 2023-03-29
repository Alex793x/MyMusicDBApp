package com.example.mymusicdemo.repository;

import com.example.mymusicdemo.model.Albums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumsRepo {

    @Autowired
    JdbcTemplate template;

    public List<Albums> fetchAll() {
        String sql = "SELECT albums.* FROM albums ORDER BY title";
        return template.query(sql, new BeanPropertyRowMapper<>(Albums.class));
    }

    public List<Albums> fetch_fk_all_artist(int fk_id) {
        String sql = "SELECT DISTINCT albums.* FROM albums " +
                "JOIN artists USING (artists_id) "+
                "WHERE albums.artists_id =" + fk_id;
        return template.query(sql, new BeanPropertyRowMapper<>(Albums.class));
    }

    public void addAlbums(Albums albums) {
        String sql = "INSERT INTO albums (title, amount, release_year, record_company_id, artists_id) " +
                        "VALUES (?, ?, ?, ?, ?)";

        template.update(sql,
                albums.getTitle(),
                albums.getAmount(),
                albums.getRelease_year(),
                albums.getRecord_company_id(),
                albums.getArtists_id());
    }

    public void deleteAlbum(int fk_id) {
        String sql = "DELETE FROM albums WHERE albums_id = ?";
        template.update(sql, fk_id);
    }

    public Albums findAlbumById(int id) {
        String sql = "SELECT * FROM albums WHERE albums_id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Albums.class), id);
    }

}
