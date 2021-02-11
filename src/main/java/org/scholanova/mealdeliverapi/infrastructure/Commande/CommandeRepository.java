package org.scholanova.mealdeliverapi.infrastructure.Commande;

import org.scholanova.mealdeliverapi.domain.Commande.Commande;
import org.springframework.data.repository.CrudRepository;

public interface CommandeRepository extends CrudRepository<Commande, Long> {

}
