package by.vikhor.travelapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(
            HttpServletRequest request, ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream()
                .map(v -> String.format("%s %s", v.getPropertyPath().toString(), v.getMessage()))
                .collect(Collectors.joining("\n"));
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(message)
                .path(request.getServletPath())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            HttpServletRequest request, IllegalArgumentException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getMessage())
                .path(request.getServletPath())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse,
                HttpStatus.BAD_REQUEST);
    }

}
