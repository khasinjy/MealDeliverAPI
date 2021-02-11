package org.scholanova.mealdeliverapi.application.Menu;

import org.scholanova.mealdeliverapi.domain.Boisson;
import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.domain.Menu.Menu;
import org.scholanova.mealdeliverapi.domain.Menu.MenuMauvaisTypeException;
import org.scholanova.mealdeliverapi.domain.Menu.MenuPersistence;
import org.scholanova.mealdeliverapi.infrastructure.repository.BoissonRepository;
import org.scholanova.mealdeliverapi.infrastructure.repository.MenuRepository;
import org.scholanova.mealdeliverapi.infrastructure.Plat.repository.NourritureRepository;
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
            ItemNourriture plat = nourritureRepository.findByName(menu.getPlat());
            ItemNourriture dessert = nourritureRepository.findByName(menu.getDessert());
            Boisson boisson = boissonRepository.findByName(menu.getBoisson());
            Menu newMenu = new Menu(entree, plat, dessert, boisson);
            menuRepository.save(newMenu);
    }

    @GetMapping("/restaurant/menus")
    public Iterable<Menu> listMenus() {
        return menuRepository.findAll();
    }

    @GetMapping("/restaurant/menus/{id}")
    public Menu getMenuById(@PathVariable Long id) {
        return menuRepository.findById(id).get();
    }

}
