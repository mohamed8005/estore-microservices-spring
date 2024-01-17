package com.example.produitservice.web;


import com.example.produitservice.config.GlobalConfig;
import com.example.produitservice.config.ProduitConfig;
import com.example.produitservice.entities.Produit;
import com.example.produitservice.respositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/feign")
public class controlerRestFeign {




    @Autowired
    ProduitRepository acheteurRepository;

   @Autowired
   GlobalConfig globalConfig;

    @Autowired
    ProduitConfig produitConfig;

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }


    @GetMapping("/produitConfig")
    public ProduitConfig produitConfig(){
        return produitConfig;
    }


    @GetMapping("/produits")
    public List<Produit> getAll(){
        return  acheteurRepository.findAll();

    }

    @GetMapping("/produits/{id}")
    public Produit getById(@PathVariable ("id") Integer id){


        return acheteurRepository.findById(id).get();

    }



}