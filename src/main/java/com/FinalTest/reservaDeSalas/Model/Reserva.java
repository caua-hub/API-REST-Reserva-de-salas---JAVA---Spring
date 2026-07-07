package com.FinalTest.reservaDeSalas.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sala_id")
    private Sala sala;
    @Embedded
    private Periodo periodo;
    private int pessoas;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Reserva() {
    }

    public Reserva(Usuario usuario, int pessoas, Periodo periodo, Sala sala) {
        this.usuario = usuario;
        this.pessoas = pessoas;
        this.periodo = periodo;
        this.sala = sala;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public int getPessoas() {
        return pessoas;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", sala=" + sala +
                ", periodo=" + periodo +
                ", pessoas=" + pessoas +
                '}';
    }
}
