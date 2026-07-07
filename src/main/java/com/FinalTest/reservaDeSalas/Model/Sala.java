package com.FinalTest.reservaDeSalas.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int capacidadeMaxima;
    @Enumerated(EnumType.STRING)
    private Status  status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sala")
    private List<Reserva> reservas;

    @Transient
    private Reserva reservaAtual;
    @Transient
    private List<Periodo>  periodos;

    public Sala(String nome, int capacidadeMaxima, Status status, List<Reserva> reservas, Reserva reservaAtual, List<Periodo> periodos) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.status = status;
        this.reservas = reservas;
        this.reservaAtual = reservaAtual;
        this.periodos = periodos;
    }

    public Sala() {
    }



    public Sala(String sala1, int i, Status status) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public String getNome() {
        return nome;
    }

    public Reserva getReservaAtual() {
        LocalDateTime agora = LocalDateTime.now();
        return reservas.stream()
                .filter(r -> r.getPeriodo().estaNoIntervalo(agora)) // depende de como Periodo guarda datas
                .findFirst()
                .orElse(null);
    }

    public Status getStatus() {
        return status;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }
}
