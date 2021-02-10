package org.scholanova.mealdeliverapi.domain.Commande;

import org.scholanova.mealdeliverapi.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CommandeRepositories {

    @Autowired
    JdbcTemplate jdbc;


    List<Commande> getAllCommandesByRestaurant(Restaurant restaurant) {
        List<Commande> result = jdbc.query("select * from commandes cmd left outter join restaurants rst on cmd.idRestaurant = " + restaurant.getId(), new BeanPropertyRowMapper(Commande.class));
        return result;
    }

    public List<Commande> getAllCommandes() {
        List<Commande> result = jdbc.query("select * from commandes", new BeanPropertyRowMapper(Commande.class));
        return result;
    }

    public void addCommande(Commande commande) throws ParseException {
        jdbc.update("INSERT INTO commandes (idClient,idRestaurant,contenuCommande,heureLivraison,etat,couvertPlastique)" +
                " VALUES ("+ commande.getClient().getId() +
                ", " + commande.getRestaurant().getId() +
                ", " + commande.getContenu().toString() +
                ", " + commande.getHeureLivraison() +
                ", " + commande.getEtat().toString() +
                ", " + commande.isCouvertPlastique() +");");
    }




}
