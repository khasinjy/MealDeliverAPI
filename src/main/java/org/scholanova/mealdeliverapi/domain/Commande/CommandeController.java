package org.scholanova.mealdeliverapi.domain.Commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    CommandeService commandeService;

    @GetMapping
    @ResponseBody
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

}
