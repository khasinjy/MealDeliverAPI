package org.scholanova.mealdeliverapi.infrastructure.Plat;

import org.scholanova.mealdeliverapi.domain.ItemNourriture;

import java.util.List;

public interface MainCourseRepository {

    List<ItemNourriture> listAll();

}
