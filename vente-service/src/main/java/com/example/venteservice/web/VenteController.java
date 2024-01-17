package com.example.venteservice.web;

import com.example.venteservice.Produit.ProduitFindController;
import com.example.venteservice.acheteur.AcheteurFindController;
import com.example.venteservice.entities.Vente;
import com.example.venteservice.kafka.Producer;
import com.example.venteservice.models.Acheteur;
import com.example.venteservice.models.Produit;
import com.example.venteservice.repositories.VenteRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class VenteController {

    @Autowired
    VenteRepository venteRepository;
    @Autowired
    AcheteurFindController acheteurFindController;
    @Autowired
    ProduitFindController produitFindController;

    @Autowired
    Producer producer;

    @GetMapping("/vente")
    public List<Vente> getAll(){
        List<Produit> lp = produitFindController.getAll();
        List<Acheteur> la= acheteurFindController.getAll();

        List<Vente> l= venteRepository.findAll();


        for(Vente v:l){
            for(Produit p:lp) {
                if(v.getIdp()==p.getIdP()) {

                    v.setProduit(p);break;
                }
            }
            for(Acheteur a:la) {
                if(v.getIda()==a.getIdA()) {

                    v.setAcheteur(a);break;
                }
            }
        }


        return l;
    }


    @GetMapping("/vente/vente/{id}")
    public List<Vente> getuser(@PathVariable ("id") Integer id){
        List<Produit> lp = produitFindController.getAll();
        List<Acheteur> la= acheteurFindController.getAll();

        List<Vente> l= venteRepository.findAll();

        List<Vente> l2=new LinkedList<>();
        for(Vente v:l){

            if(v.getIda()==id){

            for(Produit p:lp) {
                if(v.getIdp()==p.getIdP()) {

                    v.setProduit(p);break;
                }
            }
            for(Acheteur a:la) {
                if(v.getIda()==a.getIdA()) {

                    v.setAcheteur(a);break;
                }
            }
                l2.add(v);
        }
            }


        return l2;
    }

    @PostMapping("/vente")
    public void add(@RequestBody Vente vente){
        venteRepository.save(vente);
        System.out.println(vente.getIdp().toString()+" "+vente.getQuantite());
        producer.sendMessageToTopic(
                vente.getIdp().toString()+" "+vente.getQuantite()
        );
    }

    @PutMapping("/vente/{id}")
    public void save(@PathVariable ("id") Integer id, @RequestBody Vente a){
        Vente ar = venteRepository.findById(id).get();

        BeanUtils.copyProperties(a,ar);

        venteRepository.save(ar);
    }


    @DeleteMapping("/vente/{id}")
    public void supprimer(@PathVariable ("id") Integer id){
        venteRepository.deleteById(id);
    }


}
