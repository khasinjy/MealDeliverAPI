package org.scholanova.mealdeliverapi.infrastructure.Plat.repository;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.springframework.data.repository.CrudRepository;

public interface NourritureRepository  extends CrudRepository<ItemNourriture, Long> {
}
