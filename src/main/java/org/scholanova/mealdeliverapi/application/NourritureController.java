package org.scholanova.mealdeliverapi.application;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.infrastructure.repository.NourritureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant/{id}")
public class NourritureController {

    @Autowired
    NourritureRepository nourritureRepository;

    @GetMapping("/carte")
    public Iterable<ItemNourriture> listNourriture () {
        return nourritureRepository.findAll();
    }

    @PostMapping("/carte/add")
    public void addNourriture(@RequestBody ItemNourriture nourriture) {
        nourritureRepository.save(nourriture);
    }

    @DeleteMapping("/carte/delete/{id}")
    public void deleteNourriture(@PathVariable Long id) {
        nourritureRepository.deleteById(id);
    }

}
