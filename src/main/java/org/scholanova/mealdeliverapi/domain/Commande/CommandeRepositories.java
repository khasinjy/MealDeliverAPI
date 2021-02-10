package org.scholanova.mealdeliverapi.domain.Commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class CommandeRepositories {

    @Autowired
    JdbcTemplate jdbc;

    public List<Commande> getAllCommandes() {
        List<Commande> result = jdbc.query("select * from commandes", new BeanPropertyRowMapper(Commande.class));
        return result;
    }

    public void addCommande(Commande commande) throws ParseException {

        Long id = commande.getClient().getId();
        Date date = new SimpleDateFormat().parse(String.valueOf(commande.getHeureLivraison() != null ? String.valueOf(commande.getHeureLivraison()) : new Date()));
        


        jdbc.update("INSERT INTO commandes (id,idRestaurant,heureLivraison,etat,nomCommande,couvertPlastique,adresseLivraison,adresseRestaurant)" +
                " VALUES (id,idRestaurant,heureLivraison,etat,nomCommande,couvertPlastique,adresseLivraison,adresseRestaurant);");
    }




}
