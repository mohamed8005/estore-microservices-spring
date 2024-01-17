package com.example.produitservice.respositories;

import com.example.produitservice.entities.Category;
import com.example.produitservice.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CategogyRepository extends JpaRepository<Category,Integer> {
}
