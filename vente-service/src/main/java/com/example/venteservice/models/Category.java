package com.example.venteservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString @Data
public class Category {

    private Integer idc;
    private String nom;

}
