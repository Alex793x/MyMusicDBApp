package com.example.mymusicdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Artists {
    private int artists_id;
    private String first_name;
    private String last_name;
    private int birth_year;
    private int record_company_id;
}
