package org.scholanova.mealdeliverapi.application;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.infrastructure.Plat.repository.NourritureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NourritureController {

    @Autowired
    NourritureRepository nourritureRepository;

    @GetMapping("/restaurant/carte")
    public Iterable<ItemNourriture> listMainCourses () {
        return nourritureRepository.findAll();
    }

    @PostMapping("/restaurant/carte/add")
    public void addNourriture(@RequestBody ItemNourriture nourriture) {
        nourritureRepository.save(nourriture);
    }

}
