package com.example.produitservice.kafka;

import com.example.produitservice.entities.Produit;
import com.example.produitservice.respositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    ProduitRepository acheteurRepository;


    @KafkaListener(topics = "UpdateProductTopic",groupId = "UpdateProductTopicGroup")
    public void listenToTopic(String receivedMessage){
        System.out.println(
                "Product Quantity updated succesfuly"
        );
        System.out.println(
                receivedMessage
        );
        Integer idp=Integer.parseInt(receivedMessage.split(" ")[0]);
        Integer quantite=Integer.parseInt(receivedMessage.split(" ")[1]);
        Produit p= acheteurRepository.findById(idp).get();
        p.setQuantite(p.getQuantite()-quantite);
        acheteurRepository.save(p);
    }
}
