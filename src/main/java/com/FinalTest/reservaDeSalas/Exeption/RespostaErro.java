package com.FinalTest.reservaDeSalas.Exeption;

public record RespostaErro(
        int status,
        String mensagem,
        String campo
) {
}
