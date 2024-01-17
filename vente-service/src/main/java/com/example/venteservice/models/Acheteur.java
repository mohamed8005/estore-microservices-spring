package com.example.venteservice.models;

import lombok.*;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString @Data
public class Acheteur {

    private Integer idA;
    private String username;
    private Ville ville;


}
