package org.scholanova.mealdeliverapi.application.controllers;

import org.scholanova.mealdeliverapi.domain.Produit.Produit;
import org.scholanova.mealdeliverapi.infrastructure.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProduitController {

    @Autowired
    ProduitRepository produitRepository;

    @GetMapping("/restaurant/carte")
    public Iterable<Produit> listProduits () {
        return produitRepository.findAll();
    }

    @PostMapping("/restaurant/carte/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduit(@RequestBody Produit produit) {
        produitRepository.save(produit);
    }

    @DeleteMapping("/restaurant/carte/delete/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitRepository.deleteById(id);
    }

}
