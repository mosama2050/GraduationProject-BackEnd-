package com.mufic.Final.api.v2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Long id;

    private String title;


    private String img;

    private String body;


    private Long user;

    private String url;
}
