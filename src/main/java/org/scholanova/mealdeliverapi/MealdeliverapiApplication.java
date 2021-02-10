package org.scholanova.mealdeliverapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;

@SpringBootApplication
public class MealdeliverapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MealdeliverapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
