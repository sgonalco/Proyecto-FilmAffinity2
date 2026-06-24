package es.uah.serverFilmAffinity2.exceptions;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(
            ResourceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(
                        404,
                        "Resource not found",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(
            BadRequestException ex) {

        return ResponseEntity.badRequest()
                .body(new ApiError(
                        400,
                        "Bad Request",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiError> handleConstraintViolation(
            ConstraintViolationException ex) {

        String message = ex.getConstraintViolations()
                .stream()
                .findFirst()
                .map(v -> v.getMessage())
                .orElse("Validation error");

        return ResponseEntity.badRequest()
                .body(new ApiError(
                        400,
                        "Bad Request",
                        message
                ));
    }
}
