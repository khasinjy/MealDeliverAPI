package org.scholanova.mealdeliverapi.infrastructure.Menu;

import org.scholanova.mealdeliverapi.domain.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long> {
}
