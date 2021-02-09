package org.scholanova.mealdeliverapi.application;

import org.scholanova.mealdeliverapi.domain.ItemNourriture;
import org.scholanova.mealdeliverapi.infrastructure.Plat.MainCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealController {

    @Autowired
    MainCourseRepository mainCourseRepository;


    @GetMapping("/restaurant/carte")
    public List<ItemNourriture> listMainCourses () {
        return mainCourseRepository.listAll();

    }

}
