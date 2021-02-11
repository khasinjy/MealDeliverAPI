package org.scholanova.mealdeliverapi.domain.Restaurant.Exception;

public class RestaurantNonTrouveException extends RuntimeException {
    public RestaurantNonTrouveException(String message) {
        super(message);
    }
}
