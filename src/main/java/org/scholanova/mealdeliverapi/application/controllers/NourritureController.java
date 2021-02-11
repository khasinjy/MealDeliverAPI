package org.scholanova.mealdeliverapi.application.controllers;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.domain.Restaurant.Exception.RestaurantNonTrouveException;
import org.scholanova.mealdeliverapi.infrastructure.repository.NourritureRepository;
import org.scholanova.mealdeliverapi.infrastructure.repository.RestaurantRepository;
import org.scholanova.mealdeliverapi.infrastructure.repository.RestoContientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class NourritureController {

    @Autowired
    NourritureRepository nourritureRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestoContientRepository restoContientRepository;

    @GetMapping("/{id_resto}/carte")
    public List<ItemNourriture> listeNourriture (@PathVariable Long id_resto) {
        verifSiRestoExist(id_resto);
        return restoContientRepository.getCarteByRestaurantId(id_resto);
    }

    @PostMapping("/{id_resto}/carte/add")
    public void addNourriture(@PathVariable Long id_resto, @RequestBody ItemNourriture nourriture) {
        verifSiRestoExist(id_resto);
        nourritureRepository.save(nourriture);
    }

    @DeleteMapping("/{id_resto}/carte/delete/{id}")
    public void deleteNourriture(@PathVariable Long id_resto, @PathVariable Long id_nourriture) {
//        verifSiRestoExist(id_resto);
//        restoContientRepository.deleteNourritureDeLaCarte(id_resto, id_nourriture);
    }

    private void verifSiRestoExist(Long id_resto) {
        if(restaurantRepository.findById(id_resto).isEmpty()){
            throw new RestaurantNonTrouveException("Le restaurant avec l'id " + id_resto + " n'existe pas.");
        }
    }

}
