package org.scholanova.mealdeliverapi.application;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.infrastructure.Plat.repository.NourritureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MealController {

    @Autowired
    NourritureRepository nourritureRepository;

    @GetMapping("/restaurant/carte")
    public Iterable<ItemNourriture> listMainCourses () {
        return nourritureRepository.findAll();
    }

}
