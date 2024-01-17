package com.example.acheteurservice;

import com.example.acheteurservice.entities.Acheteur;
import com.example.acheteurservice.repositories.AcheteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AcheteurServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcheteurServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(AcheteurRepository acheteurRepository){
        return args -> {
           // acheteurRepository.save(Acheteur.builder()
             //       .username("Ali Mohammed")
               //     .ville("Rabat")
                 //   .build());


         //   List<Acheteur> liste = acheteurRepository.findAll();

           // for (Acheteur a:liste){
             //   System.out.println("*************************");
               // System.out.println(a.getUsername());
               // System.out.println(a.getVille());
            //}

        };
    }

}
