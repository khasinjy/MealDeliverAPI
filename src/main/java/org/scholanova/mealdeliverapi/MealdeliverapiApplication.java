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
	}

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public void run(String... args) throws Exception {

		jdbc.execute("DROP TABLE IF EXISTS nourriture;");
		jdbc.execute("DROP TABLE IF EXISTS menus;");
		jdbc.execute("DROP TABLE IF EXISTS restaurants;");
		jdbc.execute("DROP TABLE IF EXISTS commandes;");

		jdbc.execute("CREATE TABLE nourriture(id INTEGER PRIMARY KEY AUTO_INCREMENT, prix FLOAT, nom VARCHAR, tempsPreparation INT, type VARCHAR);");
		jdbc.execute("CREATE TABLE menus(id INTEGER PRIMARY KEY AUTO_INCREMENT, entree INT, plat INT, dessert INT, boisson INT, supplement INT);");
		jdbc.execute("CREATE TABLE restaurants(id INTEGER PRIMARY KEY AUTO_INCREMENT, nom VARCHAR, adresse VARCHAR);");
//		jdbc.execute("CREATE TABLE commandes(id INTEGER PRIMARY KEY AUTO_INCREMENT);");
//
		jdbc.batchUpdate("INSERT INTO nourriture(prix, nom, tempsPreparation, type) values" +
				"(13, 'Lasagne', 30, 'PLAT')," +
				"(10, 'Steak Frites',15, 'PLAT')," +
				"(2.50, 'Glace parfum Vanille', 30, 'DESSERT');");
		jdbc.batchUpdate("INSERT INTO restaurants(nom, adresse) values('Le soleil levant', '8 avenue Genéral de Gaulle');");

	}
}
