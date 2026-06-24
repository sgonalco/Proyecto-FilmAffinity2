package es.uah.serverFilmAffinity2.exceptions;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
