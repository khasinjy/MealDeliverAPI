package org.scholanova.mealdeliverapi.application.controllers;

import org.scholanova.mealdeliverapi.domain.Boisson;
import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.domain.Restaurant.Exception.ProduitNonDisponibleException;
import org.scholanova.mealdeliverapi.domain.Restaurant.Exception.RestaurantNonTrouveException;
import org.scholanova.mealdeliverapi.domain.Restaurant.Restaurant;
import org.scholanova.mealdeliverapi.domain.Restaurant.RestoContient;
import org.scholanova.mealdeliverapi.domain.Restaurant.RestoContientBoissons;
import org.scholanova.mealdeliverapi.infrastructure.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestoContientController {

    @Autowired
    NourritureRepository nourritureRepository;

    @Autowired
    BoissonRepository boissonRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestoContientRepository restoContientRepository;

    @Autowired
    RestoContientBoissonsRepository restoContientBoissonsRepository;

    @GetMapping("/{id_resto}/carte/nourriture")
    public List<ItemNourriture> listeNourriture(@PathVariable Long id_resto) {
        verifSiRestoExist(id_resto);
        List<ItemNourriture> listeNourriture = restoContientRepository.getCarteByRestaurantId(id_resto);
        return  listeNourriture;
    }

    @GetMapping("/{id_resto}/carte/boissons")
    public List<Boisson> listeBoissons(@PathVariable Long id_resto) {
        verifSiRestoExist(id_resto);
        List<Boisson> listeBoissons = restoContientBoissonsRepository.getCarteByRestaurantId(id_resto);
        return listeBoissons;
    }

    @PostMapping("/{id_resto}/carte/nourriture/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNourritureAlaCarte(@PathVariable Long id_resto, @RequestBody ItemNourriture nourriture) {
        verifSiRestoExist(id_resto);
        nourritureRepository.save(nourriture);
        Restaurant resto = restaurantRepository.findById(id_resto).get();
        restoContientRepository.save(new RestoContient(resto, nourriture));
    }

    @PostMapping("/{id_resto}/carte/boisson/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBoissonAlaCarte(@PathVariable Long id_resto, @RequestBody Boisson boisson) {
        verifSiRestoExist(id_resto);
        boissonRepository.save(boisson);
        Restaurant resto = restaurantRepository.findById(id_resto).get();
        restoContientBoissonsRepository.save(new RestoContientBoissons(resto, boisson));
    }

    @DeleteMapping("/{id_resto}/carte/nourriture/delete/{id_nourriture}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void retirerNourritureDeLaCarte(@PathVariable Long id_resto, @PathVariable Long id_nourriture) {
        verifSiRestoExist(id_resto);
        Long id = restoContientRepository.getIdRestoContientNourritureByIds(id_resto, id_nourriture);
        if(id == null){ throw new ProduitNonDisponibleException("Le restaurant ne propose déjà plus ce produit.");}
        restoContientRepository.deleteById(id);
    }

    @DeleteMapping("/{id_resto}/carte/boisson/delete/{id_nourriture}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void retirerBoissonDeLaCarte(@PathVariable Long id_resto, @PathVariable Long id_boisson) {
        verifSiRestoExist(id_resto);
        Long id = restoContientBoissonsRepository.getIdRestoContientBoissonsByIds(id_resto, id_boisson);
        if(id == null){ throw new ProduitNonDisponibleException("Le restaurant ne propose déjà plus ce produit.");}
        restoContientBoissonsRepository.deleteById(id);
    }

    private void verifSiRestoExist(Long id_resto) {
        if(restaurantRepository.findById(id_resto).isEmpty()){
            throw new RestaurantNonTrouveException("Le restaurant avec l'id " + id_resto + " n'existe pas.");
        }
    }

}
