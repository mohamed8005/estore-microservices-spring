package com.example.acheteurservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor@AllArgsConstructor@ToString@Builder@Getter@Setter
public class Acheteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idA;
    private String username;
    private String  ville;



}
