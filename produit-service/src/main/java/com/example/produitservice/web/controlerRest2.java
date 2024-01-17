package com.example.produitservice.web;


import com.example.produitservice.config.GlobalConfig;
import com.example.produitservice.config.ProduitConfig;
import com.example.produitservice.entities.Category;
import com.example.produitservice.entities.Produit;
import com.example.produitservice.respositories.CategogyRepository;
import com.example.produitservice.respositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")
public class controlerRest2 {




    @Autowired
    CategogyRepository acheteurRepository;

   @Autowired
   GlobalConfig globalConfig;

    @Autowired
    ProduitConfig produitConfig;







    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/categories")
    public List<Category> getAll(){
        return  acheteurRepository.findAll();

    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/categories/{id}")
    public Category getById(@PathVariable ("id") Integer id){


        return acheteurRepository.findById(id).get();

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/categories/{id}")
    public void save(@PathVariable ("id") Integer id, @RequestBody Category a){
        a.setIdc(id);

        acheteurRepository.save(a);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/categories")
    public void add(@RequestBody Category a){
        acheteurRepository.save(a);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/categories/{id}")
    public void supprimer(@PathVariable ("id") Integer id){
        acheteurRepository.deleteById(id);
    }

}