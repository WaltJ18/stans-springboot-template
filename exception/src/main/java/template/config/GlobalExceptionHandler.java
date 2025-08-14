package template.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import template.ResponseDTO;
import template.domain.ErrorResponseDTO;
import template.exception.ResourceNotFoundException;

import java.time.OffsetDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     *
     * This Exception Handler For Request Path that does not exist
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundPath(
            NoHandlerFoundException ex,
            HttpServletRequest request) {

        ErrorResponseDTO error = new ErrorResponseDTO(
                OffsetDateTime.now(),
                "The requested path does not exist",
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDTO<ErrorResponseDTO>> handleResourceNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request) {

        ErrorResponseDTO error = new ErrorResponseDTO(
                OffsetDateTime.now(),
                ex.getMessage(),
                request.getRequestURI()
        );

        ResponseDTO<ErrorResponseDTO> response = new ResponseDTO<>(
                error, "Not Found"
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


}
