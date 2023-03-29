package com.example.mymusicdemo.repository;


import com.example.mymusicdemo.model.RecordCompanies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordCompaniesRepo {

    @Autowired
    JdbcTemplate template;

    public List<RecordCompanies> fetchAll() {
        String sql = "SELECT record_companies.* FROM record_companies ORDER BY company_name";
        RowMapper<RecordCompanies> rowMapper = new BeanPropertyRowMapper<>(RecordCompanies.class);
        return template.query(sql, rowMapper);
    }

    public List<RecordCompanies> fetch_fk_all_albums(int fk_id) {
        String sql = "SELECT DISTINCT record_companies.* FROM record_companies " +
                "JOIN albums USING (record_company_id) " +
                "WHERE albums.record_company_id = " + fk_id;

        return template.query(sql, new BeanPropertyRowMapper<>(RecordCompanies.class));
    }

    public List<RecordCompanies> fetch_fk_all_artists(int fk_id) {
        String sql = "SELECT DISTINCT record_companies.* FROM record_companies " +
                "JOIN artists USING (record_company_id) " +
                "WHERE artists.record_company_id = " + fk_id;
        return template.query(sql, new BeanPropertyRowMapper<>(RecordCompanies.class));
    }



    public void addRecordCompany(RecordCompanies recordCompanies) {
        String sql = "INSERT INTO record_companies (company_name, address, city, phonenumber) VALUES (?, ?, ?, ?)";
        template.update(sql,
                recordCompanies.getCompany_name(),
                recordCompanies.getAddress(),
                recordCompanies.getCity(),
                recordCompanies.getPhonenumber());
    }

    public RecordCompanies findRecordCompanyById(int id) {
        String sql = "SELECT record_companies.* FROM record_companies WHERE record_company_id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(RecordCompanies.class), id);
    }

    public void updateRecordCompany(int id, RecordCompanies recordCompanies) {
        String sql = "UPDATE record_companies SET company_name = ?, address = ?, city = ?, phonenumber = ? WHERE record_company_id = ?";

        template.update(sql,
                recordCompanies.getCompany_name(),
                recordCompanies.getAddress(),
                recordCompanies.getCity(),
                recordCompanies.getPhonenumber(),
                id
        );
    }

    public void deleteRecordCompany(int id) {
        String sql = "DELETE FROM record_companies WHERE record_company_id = ?";
        template.update(sql, id);
    }

}
