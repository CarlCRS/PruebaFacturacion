package ec.sasf.ms_comp_prueba_Carlos_Chica.Exception;


import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalExcepcion.class)
    public ResponseEntity<?> notFound(GlobalExcepcion ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> badRequest(MethodArgumentNotValidException ex) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Datos de entrada invalidos"));
    }
}
