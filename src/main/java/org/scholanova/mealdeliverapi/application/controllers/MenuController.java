package org.scholanova.mealdeliverapi.application.controllers;

import org.scholanova.mealdeliverapi.domain.Produit.Produit;
import org.scholanova.mealdeliverapi.domain.Menu.Exception.MenuChoixIndisponibleException;
import org.scholanova.mealdeliverapi.domain.Menu.Menu;
import org.scholanova.mealdeliverapi.domain.Menu.MenuPersistence;
import org.scholanova.mealdeliverapi.infrastructure.repository.MenuRepository;
import org.scholanova.mealdeliverapi.infrastructure.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    MenuRepository menuRepository;

    @PostMapping("/restaurant/addMenu")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenu(@RequestBody MenuPersistence menu) {

            Produit entree = produitRepository.findByName(menu.getEntree());
            if(entree == null){ throw new MenuChoixIndisponibleException(menu.getEntree() + " n'est pas disponible.");}

            Produit plat = produitRepository.findByName(menu.getPlat());
            if(plat == null){ throw new MenuChoixIndisponibleException(menu.getPlat() + " n'est pas disponible.");}

            Produit dessert = produitRepository.findByName(menu.getDessert());
            if(dessert == null){ throw new MenuChoixIndisponibleException(menu.getDessert() + " n'est pas disponible.");}

            Produit boisson = produitRepository.findByName(menu.getBoisson());
            if(boisson == null){ throw new MenuChoixIndisponibleException(menu.getBoisson() + " n'est pas disponible.");}

            Menu newMenu = new Menu(entree, plat, dessert, boisson, menu.getPrix());
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
