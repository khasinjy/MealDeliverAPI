package org.scholanova.mealdeliverapi.domain.Menu.Exception;

public class MenuChoixIndisponibleException extends RuntimeException {
    public MenuChoixIndisponibleException(String message) {
        super(message);
    }
}
