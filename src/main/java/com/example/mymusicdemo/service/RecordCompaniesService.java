package com.example.mymusicdemo.service;

import com.example.mymusicdemo.model.Albums;
import com.example.mymusicdemo.model.RecordCompanies;
import com.example.mymusicdemo.repository.RecordCompaniesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class RecordCompaniesService {

    @Autowired
    RecordCompaniesRepo recordCompaniesRepo;

    public List<RecordCompanies> fetchAll() {
        return recordCompaniesRepo.fetchAll();
    }

    public List<RecordCompanies> fetch_fk_all_albums(int fk_id) {
        return recordCompaniesRepo.fetch_fk_all_albums(fk_id);
    }

    public List<RecordCompanies> fetch_fk_all_artists(int fk_id) {
        return recordCompaniesRepo.fetch_fk_all_artists(fk_id);
    }

    public void addRecordCompany(RecordCompanies recordCompanies) {
        recordCompaniesRepo.addRecordCompany(recordCompanies);
    }

    public RecordCompanies findRecordCompanyById(int id) {
        return recordCompaniesRepo.findRecordCompanyById(id);
    }

    public void updateRecordCompany(int id, RecordCompanies recordCompanies) {
        recordCompaniesRepo.updateRecordCompany(id, recordCompanies);
    }

    public void deleteRecordCompany(int id) {
        recordCompaniesRepo.deleteRecordCompany(id);
    }
}
