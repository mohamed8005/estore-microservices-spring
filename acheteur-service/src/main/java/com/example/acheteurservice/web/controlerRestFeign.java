package com.example.acheteurservice.web;



import com.example.acheteurservice.entities.Acheteur;
import com.example.acheteurservice.repositories.AcheteurRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/feign")
public class controlerRestFeign {




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




}