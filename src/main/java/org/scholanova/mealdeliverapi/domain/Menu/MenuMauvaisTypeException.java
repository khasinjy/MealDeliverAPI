package org.scholanova.mealdeliverapi.domain.Menu;

public class MenuMauvaisTypeException extends RuntimeException {
    public MenuMauvaisTypeException(String message) {
        super(message);
    }
}
