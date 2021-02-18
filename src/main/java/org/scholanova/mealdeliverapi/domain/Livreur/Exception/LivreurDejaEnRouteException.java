package org.scholanova.mealdeliverapi.domain.Livreur.Exception;

public class LivreurDejaEnRouteException extends RuntimeException{
    public LivreurDejaEnRouteException(String message) {
        super(message);
    }
}
