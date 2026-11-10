package dev.java10x.teste01_spring.handler;

import dev.java10x.teste01_spring.exception.RecursoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //informa ao Spring que essa classe vai tratar exceções globalmente nos Controllers.
public class GlobalException {

    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ResponseEntity<String> tratarErro(RecursoNaoEncontrado e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
        public ResponseEntity<String> exceptionHandler(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }


}
