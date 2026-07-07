package com.FinalTest.reservaDeSalas.Service;

import com.FinalTest.reservaDeSalas.DTOs.ReservaDTO;
import com.FinalTest.reservaDeSalas.Exeption.ReservaInvalidaExeption;
import com.FinalTest.reservaDeSalas.Model.*;
import com.FinalTest.reservaDeSalas.Repository.ReservaRepository;
import com.FinalTest.reservaDeSalas.Repository.SalaRepository;
import com.FinalTest.reservaDeSalas.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository  reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SalaRepository salaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void fazerReserva(ReservaDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Sala sala = salaRepository.findById(dto.salaId())
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

        Periodo periodo = new Periodo(dto.inicio(), dto.fim());

        sala.getPeriodos()
                .stream()
                .forEach(PS -> {
                    if (periodo.getInicio().isBefore(PS.getFim()) && periodo.getFim().isAfter(PS.getInicio())){
                        throw new ReservaInvalidaExeption("Conflito de periodos");
                    }
                });
        if (dto.pessoas() <= sala.getCapacidadeMaxima() && sala.getStatus() == Status.ATIVA && dto.pessoas() >= 0) {
            reservaRepository.save(new Reserva(usuario, dto.pessoas(), periodo, sala));
        } else  {
            throw new ReservaInvalidaExeption("Erro de entrada");
        }

    }

    public List<ReservaDTO> listaReservas() {
        return reservaRepository.findAll().stream()
                .map(R -> new ReservaDTO(R.getId(), R.getSala().getId(), R.getPeriodo().getInicio(), R.getPeriodo().getFim(), R.getPessoas()))
                .collect(Collectors.toUnmodifiableList());
    }
}
