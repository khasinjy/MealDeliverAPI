package org.scholanova.mealdeliverapi;

import org.jboss.jandex.Main;
import org.scholanova.mealdeliverapi.controller.MealController;
import org.scholanova.mealdeliverapi.model.MainCourse;
import org.scholanova.mealdeliverapi.repositories.MainCourseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MealdeliverapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(MealdeliverapiApplication.class, args);
		System.out.println("group3 running");

	}

}
