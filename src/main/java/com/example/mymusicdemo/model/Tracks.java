package com.example.mymusicdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class Tracks {

    private int tracks_id;
    private String title;
    private double duration;
    private int albums_id;
}
