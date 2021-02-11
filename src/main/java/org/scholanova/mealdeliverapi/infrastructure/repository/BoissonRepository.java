package org.scholanova.mealdeliverapi.infrastructure.repository;

import org.scholanova.mealdeliverapi.domain.Boisson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BoissonRepository  extends CrudRepository<Boisson, Long> {

    @Query("SELECT b FROM Boisson b WHERE b.nom = ?1")
    Boisson findByName(String nom);
}