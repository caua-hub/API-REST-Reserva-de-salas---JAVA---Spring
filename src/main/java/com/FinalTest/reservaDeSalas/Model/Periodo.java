package com.FinalTest.reservaDeSalas.Model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Embeddable
public class Periodo {
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Periodo() {
    }

    public Periodo(LocalDateTime inicio, LocalDateTime fim) {
        if (inicio.isAfter(fim)) {
            throw new IllegalArgumentException("Período inválido.");
        }

        this.inicio = inicio;
        this.fim = fim;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public boolean estaNoIntervalo(LocalDateTime agora){
        return !agora.isBefore(inicio) && !agora.isAfter(fim);
    }

}
