package org.scholanova.mealdeliverapi.infrastructure.repository;

import org.scholanova.mealdeliverapi.domain.Produit.Produit;
import org.scholanova.mealdeliverapi.domain.Restaurant.RestoContient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestoContientRepository extends CrudRepository<RestoContient, Long> {

    @Query("SELECT p FROM Produit p, RestoContient c, Restaurant r " +
            "WHERE p.id = c.produit.id " +
            "AND r.id = c.restaurant.id " +
            "AND c.restaurant.id = ?1 " +
            "ORDER BY type DESC")
    List<Produit> getCarteByRestaurantId(Long id_resto);

    @Query("SELECT c.id FROM Produit p, RestoContient c, Restaurant r " +
            "WHERE c.restaurant.id = ?1 " +
            "AND c.produit.id = ?2")
    Long getIdRestoContienteByIds(Long id_resto, Long id_produit);

}
