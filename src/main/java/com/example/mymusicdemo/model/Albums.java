package com.example.mymusicdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class Albums {
    private int albums_id;
    private String title;
    private int amount;
    private int release_year;
    private int record_company_id;
    private int artists_id;
}
