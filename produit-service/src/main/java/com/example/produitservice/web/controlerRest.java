package com.example.produitservice.web;



import com.example.produitservice.config.GlobalConfig;
import com.example.produitservice.config.ProduitConfig;
import com.example.produitservice.entities.Produit;
import com.example.produitservice.respositories.ProduitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")
public class controlerRest {




    @Autowired
    ProduitRepository acheteurRepository;

   @Autowired
   GlobalConfig globalConfig;

    @Autowired
    ProduitConfig produitConfig;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/produitConfig")
    public ProduitConfig produitConfig(){
        return produitConfig;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/produits")
    public List<Produit> getAll(){
        return  acheteurRepository.findAll();

    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/produits/{id}")
    public Produit getById(@PathVariable ("id") Integer id){


        return acheteurRepository.findById(id).get();

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/produits/{id}")
    public void save(@PathVariable ("id") Integer id, @RequestBody Produit a){
        a.setIdP(id);
Produit p= acheteurRepository.findById(id).get();
p.setQuantite(a.getQuantite());
        acheteurRepository.save(p);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/produits")
    public void add(@RequestBody Produit a){
        acheteurRepository.save(a);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/produits/{id}")
    public void supprimer(@PathVariable ("id") Integer id){
        acheteurRepository.deleteById(id);
    }

}