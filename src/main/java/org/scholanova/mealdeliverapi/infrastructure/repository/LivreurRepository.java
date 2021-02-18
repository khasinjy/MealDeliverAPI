package org.scholanova.mealdeliverapi.infrastructure.repository;

import org.scholanova.mealdeliverapi.domain.Livreur.Livreur;
import org.springframework.data.repository.CrudRepository;

public interface LivreurRepository extends CrudRepository<Livreur, Long> {
}
