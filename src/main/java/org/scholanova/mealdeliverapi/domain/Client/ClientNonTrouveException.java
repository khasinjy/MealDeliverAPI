package org.scholanova.mealdeliverapi.domain.Client;

public class ClientNonTrouveException extends RuntimeException{
    public ClientNonTrouveException(String message) {
        super(message);
    }
}
