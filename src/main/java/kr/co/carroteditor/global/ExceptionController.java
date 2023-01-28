package kr.co.carroteditor.global;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validation(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String field = bindingResult.getFieldError().getField();
        String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
        ValidationResponse validationResponse = new ValidationResponse(field, defaultMessage);
        return ResponseEntity.ok(validationResponse);
    }
}
