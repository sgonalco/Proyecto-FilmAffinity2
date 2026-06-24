package es.uah.serverFilmAffinity2.exceptions;

public record ApiError (int status,
                        String error,
                        String message) {
}
