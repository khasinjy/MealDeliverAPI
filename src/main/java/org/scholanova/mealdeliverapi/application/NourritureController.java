package org.scholanova.mealdeliverapi.application;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.infrastructure.repository.NourritureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/restaurant/carte/delete/{id}")
    public void deleteNourriture(@PathVariable Long id) {
        nourritureRepository.deleteById(id);
    }

}
