package com.FinalTest.reservaDeSalas.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeExcecoes {

    @ExceptionHandler(ReservaInvalidaExeption.class)
    public ResponseEntity<RespostaErro> tratarReservaInvalida(
            ReservaInvalidaExeption ex) {

        RespostaErro erro = new RespostaErro(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );

        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RespostaErro> tratarNaoEncontrado(
            RuntimeException ex) {

        RespostaErro erro = new RespostaErro(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
