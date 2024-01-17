package com.example.acheteurservice.web;



import com.example.acheteurservice.entities.Acheteur;
import com.example.acheteurservice.repositories.AcheteurRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")
public class controlerRest {




    @Autowired
    AcheteurRepository acheteurRepository;

    @GetMapping("/acheteurs")
    public List<Acheteur> getAll(){




        return acheteurRepository.findAll();
    }

    @GetMapping("/acheteurs/{id}")
    public Acheteur getById(@PathVariable ("id") Integer id){


        Acheteur e= acheteurRepository.findById(id).get();



        return  e;
    }

    @GetMapping("/acheteurs/acheteur/{username}")
    //Public API
    public Acheteur getMenu2(@PathVariable String username) {
        Acheteur user = null;
        List<Acheteur> l=acheteurRepository.findAll();
        for(Acheteur user1 :l ) {
            if(user1.getUsername().equals(username)) {
                user=user1;
                BeanUtils.copyProperties(user1, user);
            }

        }
        return user;
    }

    @PutMapping("/acheteurs/{id}")
    public void save(@PathVariable ("id") Integer id, @RequestBody Acheteur a){
        Acheteur ar = acheteurRepository.findById(id).get();

        if(a.getUsername()!=null) {ar.setUsername(a.getUsername());}
        if(a.getVille()!=null){ar.setVille(a.getVille());}

        acheteurRepository.save(ar);
    }

    @PostMapping("/acheteurs")
    public void add(@RequestBody Acheteur a){
        acheteurRepository.save(a);
    }

    @DeleteMapping("/acheteurs/{id}")
    public void supprimer(@PathVariable ("id") Integer id){
        acheteurRepository.deleteById(id);
    }

}