package org.scholanova.mealdeliverapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MealdeliverapiApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(MealdeliverapiApplication.class, args);
		System.out.println("group3 running");

	}

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public void run(String... args) throws Exception {

		jdbc.execute("DROP TABLE IF EXISTS nourriture");
		jdbc.execute("DROP TABLE IF EXISTS menus");
		jdbc.execute("DROP TABLE IF EXISTS restaurants");
		jdbc.execute("DROP TABLE IF EXISTS commandes");

		jdbc.execute("CREATE TABLE nourriture(id INTEGER PRIMARY KEY AUTO_INCREMENT, prix FLOAT, nom VARCHAR, tempsPreparation INT)");
//		jdbc.execute("CREATE TABLE menus(id INTEGER PRIMARY KEY AUTO_INCREMENT, prix FLOAT, nom VARCHAR, tempsPreparation INT)");
//		jdbc.execute("CREATE TABLE restaurants(id INTEGER PRIMARY KEY AUTO_INCREMENT, prix FLOAT, nom VARCHAR, tempsPreparation INT)");
//		jdbc.execute("CREATE TABLE commandes(id INTEGER PRIMARY KEY AUTO_INCREMENT, prix FLOAT, nom VARCHAR, tempsPreparation INT)");
//
//		jdbc.batchUpdate("INSERT INTO flights (flight_number, departure) values(123, 'Paris')");
//		jdbc.batchUpdate("INSERT INTO flights (flight_number, departure) values(451, 'NYC')");

	}
}
