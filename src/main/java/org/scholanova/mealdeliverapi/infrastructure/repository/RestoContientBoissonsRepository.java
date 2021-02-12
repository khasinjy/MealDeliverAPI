package org.scholanova.mealdeliverapi.infrastructure.repository;

import org.scholanova.mealdeliverapi.domain.Boisson;
import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.domain.Restaurant.RestoContient;
import org.scholanova.mealdeliverapi.domain.Restaurant.RestoContientBoissons;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestoContientBoissonsRepository extends CrudRepository<RestoContientBoissons, Long> {

    @Query("SELECT b FROM Boisson b, RestoContientBoissons c, Restaurant r " +
            "WHERE b.id = c.boisson.id " +
            "AND r.id = c.restaurant.id " +
            "AND c.restaurant.id = ?1 " +
            "ORDER BY prix DESC")
    List<Boisson> getCarteByRestaurantId(Long id_resto);

    @Query("SELECT c.id FROM Boisson b, RestoContientBoissons c, Restaurant r " +
            "WHERE c.restaurant.id = ?1 " +
            "AND c.boisson.id = ?2")
    Long getIdRestoContientBoissonsByIds(Long id_resto, Long id_boisson);

}
