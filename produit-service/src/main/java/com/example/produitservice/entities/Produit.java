package com.example.produitservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString @Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idP;
    private String nom;
    private String marque;
    private Float prix;
    private Integer quantite;
    private String image;
    private String description;
    @ManyToOne
    @JoinColumn(name = "idc")
    private  Category category;
}
