package org.scholanova.mealdeliverapi.application;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.domain.Menu;
import org.scholanova.mealdeliverapi.infrastructure.Menu.MenuRepository;
import org.scholanova.mealdeliverapi.infrastructure.Plat.repository.NourritureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealController {

    @Autowired
    NourritureRepository nourritureRepository;

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/restaurant/carte")
    public Iterable<ItemNourriture> listMainCourses () {
        return nourritureRepository.findAll();

    }

//    @GetMapping("/restaurant/menus")
//    @ResponseBody
//    public List<Menu> listMenus () {
//        return menuRepository.listerTousLesMenus();
//
//    }


    @GetMapping("/restaurant/menus")
    public Iterable<Menu> listMenus() {
        return menuRepository.findAll();
    }


}
