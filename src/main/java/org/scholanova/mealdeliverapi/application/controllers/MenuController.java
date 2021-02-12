package org.scholanova.mealdeliverapi.application.controllers;

import org.scholanova.mealdeliverapi.domain.Boisson;
import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.domain.Menu.Exception.MenuChoixIndisponibleException;
import org.scholanova.mealdeliverapi.domain.Menu.Menu;
import org.scholanova.mealdeliverapi.domain.Menu.MenuPersistence;
import org.scholanova.mealdeliverapi.infrastructure.repository.BoissonRepository;
import org.scholanova.mealdeliverapi.infrastructure.repository.MenuRepository;
import org.scholanova.mealdeliverapi.infrastructure.repository.NourritureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {

    @Autowired
    NourritureRepository nourritureRepository;

    @Autowired
    BoissonRepository boissonRepository;

    @Autowired
    MenuRepository menuRepository;

    @PostMapping("/restaurant/addMenu")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenu(@RequestBody MenuPersistence menu) {

            ItemNourriture entree = nourritureRepository.findByName(menu.getEntree());
            if(entree == null){ throw new MenuChoixIndisponibleException(menu.getEntree() + " n'est pas disponible.");}

            ItemNourriture plat = nourritureRepository.findByName(menu.getPlat());
            if(plat == null){ throw new MenuChoixIndisponibleException(menu.getPlat() + " n'est pas disponible.");}

            ItemNourriture dessert = nourritureRepository.findByName(menu.getDessert());
            if(dessert == null){ throw new MenuChoixIndisponibleException(menu.getDessert() + " n'est pas disponible.");}

            Boisson boisson = boissonRepository.findByName(menu.getBoisson());
            if(boisson == null){ throw new MenuChoixIndisponibleException(menu.getBoisson() + " n'est pas disponible.");}

            Menu newMenu = new Menu(entree, plat, dessert, boisson);
            menuRepository.save(newMenu);
    }

    @GetMapping("/restaurant/menus")
    public Iterable<Menu> listeMenus() {
        return menuRepository.findAll();
    }

    @GetMapping("/restaurant/menus/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuRepository.findById(id).get();
    }

}
