package br.com.sistema.jfood.shared;

import br.com.sistema.jfood.core.application.exceptions.ClienteJaExisteException;
import br.com.sistema.jfood.core.application.exceptions.ClienteNaoIdentificadoException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerControllerExceptions {

    @ExceptionHandler( ClienteNaoIdentificadoException.class)
    ResponseEntity<HandlerErrorResponse> handlerClienteNaoIdentificadoException(ClienteNaoIdentificadoException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler( MethodArgumentNotValidException.class)
    ResponseEntity<HandlerErrorResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var f = ex.getBindingResult().getFieldError().getField();
        return ResponseEntity.badRequest().body(new HandlerErrorResponse(String.format("%s: Invalido!",f)));
    }

    @ExceptionHandler( ConstraintViolationException.class)
    ResponseEntity<HandlerErrorResponse> handlerConstraintViolationException(ConstraintViolationException ex) {
        var f = ex.getConstraintViolations().iterator().next().getMessage().toString();
        return ResponseEntity.badRequest().body(new HandlerErrorResponse(f));
    }

    @ExceptionHandler( ClienteJaExisteException.class)
    ResponseEntity<HandlerErrorResponse> handlerClienteJaExisteException(ClienteJaExisteException ex) {
        return ResponseEntity.unprocessableEntity().body(new HandlerErrorResponse(ex.getMessage()));
    }


}
