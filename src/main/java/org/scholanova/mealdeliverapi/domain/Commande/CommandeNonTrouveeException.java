package org.scholanova.mealdeliverapi.domain.Commande;

public class CommandeNonTrouveeException extends RuntimeException{
    public CommandeNonTrouveeException(String message) {
        super(message);
    }
}
