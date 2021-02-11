package org.scholanova.mealdeliverapi.infrastructure.repository;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.domain.Restaurant.RestoContient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestoContientRepository extends CrudRepository<RestoContient, Long> {

    @Query("SELECT n FROM ItemNourriture n, RestoContient c, Restaurant r " +
            "WHERE n.id = c.nourriture.id " +
            "AND r.id = c.restaurant.id " +
            "AND c.restaurant.id = ?1 " +
            "ORDER BY type DESC")
    List<ItemNourriture> getCarteByRestaurantId(Long id_resto);

//    @Query("DELETE RestoContient FROM ItemNourriture n, RestoContient c, Restaurant r " +
//            "WHERE n.id = c.nourriture.id " +
//            "AND r.id = c.restaurant.id " +
//            "AND c.restaurant.id = ?1 " +
//            "AND c.nourriture.id = ?2")
//    void deleteNourritureDeLaCarte(Long id_resto, Long id_nourriture);
}
