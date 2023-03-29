package com.example.mymusicdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RecordCompanies {
    private int record_company_id;
    private String company_name;
    private String address;
    private String city;
    private String phonenumber;
}
