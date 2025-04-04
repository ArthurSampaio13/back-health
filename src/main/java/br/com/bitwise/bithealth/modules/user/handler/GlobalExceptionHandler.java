package br.com.bitwise.bithealth.modules.user.handler;

import br.com.bitwise.bithealth.modules.user.dto.MensagemRespostaDTO;
import br.com.bitwise.bithealth.modules.user.exceptions.CPFAlreadyExistsException;
import br.com.bitwise.bithealth.modules.user.exceptions.EmailAlreadyExistsException;
import br.com.bitwise.bithealth.modules.user.exceptions.NumeroTelefoneAlreadyExistsException;
import br.com.bitwise.bithealth.modules.user.exceptions.UserGenerateTokenException;
import jdk.jfr.Experimental;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeExceptions(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    @ExceptionHandler(UserGenerateTokenException.class)
    public ResponseEntity<String> handleUserGenerateTokenException(UserGenerateTokenException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<MensagemRespostaDTO> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(MensagemRespostaDTO.erro(ex.getMessage()));
    }

    @ExceptionHandler(CPFAlreadyExistsException.class)
    public ResponseEntity<MensagemRespostaDTO> handleCpfAlreadyExists(CPFAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(MensagemRespostaDTO.erro(ex.getMessage()));
    }

    @ExceptionHandler(NumeroTelefoneAlreadyExistsException.class)
    public ResponseEntity<String> handleNumeroTelefoneAlreadyExists(NumeroTelefoneAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }


}