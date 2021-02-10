package org.scholanova.mealdeliverapi.infrastructure.Plat.repository;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;

import java.util.List;

public interface MainCourseRepository {

    List<ItemNourriture> listAll();

}
