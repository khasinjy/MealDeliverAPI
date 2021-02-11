package org.scholanova.mealdeliverapi.domain.Restaurant;

public class RestaurantNonTrouveException extends RuntimeException {
    public RestaurantNonTrouveException(String message) {
        super(message);
    }
}
