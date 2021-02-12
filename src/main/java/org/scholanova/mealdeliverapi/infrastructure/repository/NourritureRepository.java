package org.scholanova.mealdeliverapi.infrastructure.repository;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NourritureRepository  extends CrudRepository<ItemNourriture, Long> {

    @Query("SELECT n FROM ItemNourriture n WHERE n.nom = ?1")
    ItemNourriture findByName(String nom);
}
