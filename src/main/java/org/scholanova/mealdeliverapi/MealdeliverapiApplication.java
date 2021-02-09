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

//		jdbc.execute("DROP TABLE IF EXISTS plat");
//		jdbc.execute("CREATE TABLE flights(id INTEGER PRIMARY KEY AUTO_INCREMENT, flight_number INTEGER, departure VARCHAR)");
//		jdbc.batchUpdate("INSERT INTO flights (flight_number, departure) values(123, 'Paris')");
//		jdbc.batchUpdate("INSERT INTO flights (flight_number, departure) values(451, 'NYC')");

	}
}
