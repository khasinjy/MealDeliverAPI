package org.scholanova.mealdeliverapi.repositories;

import org.scholanova.mealdeliverapi.model.MainCourse;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class MainCourseRepositoryImpl implements MainCourseRepository {
    @Override
    public List<MainCourse> listAll() {

        MainCourse pouletRoti = new MainCourse();
        pouletRoti.setName("Poulet Roti");
        pouletRoti.setPrice(2.5f);
        pouletRoti.setTimeCuisson(45);

        MainCourse steakFrite = new MainCourse();
        steakFrite.setName("Steak Frite");
        steakFrite.setPrice(6.0f);
        steakFrite.setTimeCuisson(15);

        return Arrays.asList(pouletRoti,steakFrite);

    }
}
