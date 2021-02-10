package org.scholanova.mealdeliverapi.infrastructure.Plat.repository;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.infrastructure.Plat.repository.MainCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MainCourseRepositoryImpl implements MainCourseRepository {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<ItemNourriture> listAll() {
        return jdbc.query("SELECT * FROM nourriture",new BeanPropertyRowMapper<>(ItemNourriture.class));
    }
}
