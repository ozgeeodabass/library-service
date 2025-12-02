package microservice.library_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

        @ExceptionHandler(LibraryNotFoundException.class)
        public ResponseEntity<?> handle(LibraryNotFoundException excepiton){
            return new ResponseEntity<>(excepiton.getMessage(), HttpStatus.NOT_FOUND);
        }
}
