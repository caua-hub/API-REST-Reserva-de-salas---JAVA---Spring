package com.FinalTest.reservaDeSalas.Repository;

import com.FinalTest.reservaDeSalas.Model.Reserva;
import com.FinalTest.reservaDeSalas.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Reserva findById(long id);

    @Override
    List<Reserva> findAll();

    @Query("SELECT r.usuario FROM Reserva r WHERE r.id = :reservaId")
    Usuario buscarUsuarioPorReserva(Long reservaId);
}
