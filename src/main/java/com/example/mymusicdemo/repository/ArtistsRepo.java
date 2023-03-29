package com.example.mymusicdemo.repository;

import com.example.mymusicdemo.model.Artists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistsRepo {

    @Autowired
    JdbcTemplate template;

    public List<Artists> fetchAll() {
        String sql = "SELECT artists.* FROM artists ORDER BY first_name;";
        return template.query(sql, new BeanPropertyRowMapper<>(Artists.class));
    }

    public void addArtist(Artists artists) {
        String sql = "INSERT INTO artists (first_name, last_name, birth_year, record_company_id) VALUES (?, ?, ?, ?)";
        template.update(sql,
                artists.getFirst_name(),
                artists.getLast_name(),
                artists.getBirth_year(),
                artists.getRecord_company_id());
    }

}
