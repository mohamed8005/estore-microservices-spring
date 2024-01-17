package com.example.venteservice;

import com.example.venteservice.entities.Vente;
import com.example.venteservice.repositories.VenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class VenteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenteServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(VenteRepository venteRepository) {
        return args -> {
          //  venteRepository.save(Vente.builder()
            //        .idp(1).ida(1).quantite(50).build());
            //venteRepository.save(Vente.builder()
              //      .idp(1).ida(2).quantite(50).build());
           // venteRepository.save(Vente.builder()
           //         .idp(2).ida(1).quantite(50).build());
        };
    }
}
