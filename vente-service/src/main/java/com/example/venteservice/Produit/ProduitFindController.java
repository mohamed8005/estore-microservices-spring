package com.example.venteservice.Produit;


import com.example.venteservice.models.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PRODUIT-SERVICE")
public interface ProduitFindController {
    @GetMapping("/feign/produits")
    List<Produit> getAll();

    @GetMapping("/feign/produits/{idP}")
    Produit getById(@PathVariable Integer idP);


}
