package org.scholanova.mealdeliverapi.domain.Menu.Exception;

public class MenuNonTrouveException extends RuntimeException{
    public MenuNonTrouveException(String message) {
        super(message);
    }
}
