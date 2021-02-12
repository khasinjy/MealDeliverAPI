package org.scholanova.mealdeliverapi.domain.Restaurant.Exception;

public class ProduitNonDisponibleException extends RuntimeException {
    public ProduitNonDisponibleException(String message) {
        super(message);
    }
}
