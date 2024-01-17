package com.example.venteservice.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString @Data
public class Produit {

    private Integer idP;
    private String nom;
    private String marque;
    private Float prix;
    private Integer quantite;
    private String image;
    private String description;
    private  Category category;

}
