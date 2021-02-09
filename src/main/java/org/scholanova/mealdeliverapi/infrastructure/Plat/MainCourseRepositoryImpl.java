package org.scholanova.mealdeliverapi.infrastructure.Plat;

import org.scholanova.mealdeliverapi.domain.Plat;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class MainCourseRepositoryImpl implements MainCourseRepository {
    @Override
    public List<Plat> listAll() {

        Plat pouletRoti = new Plat();
        pouletRoti.setNom("Poulet Roti");
        pouletRoti.setPrix(2.5f);
        pouletRoti.setTempsPreparation(45);

        Plat steakFrite = new Plat();
        steakFrite.setNom("Steak Frite");
        steakFrite.setPrix(6.0f);
        steakFrite.setTempsPreparation(15);

        return Arrays.asList(pouletRoti,steakFrite);

    }
}
