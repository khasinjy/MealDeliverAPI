package org.scholanova.mealdeliverapi.infrastructure.repository;

import org.scholanova.mealdeliverapi.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}
