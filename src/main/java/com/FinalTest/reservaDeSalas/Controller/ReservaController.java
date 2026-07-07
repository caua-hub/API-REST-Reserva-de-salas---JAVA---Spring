package com.FinalTest.reservaDeSalas.Controller;

import com.FinalTest.reservaDeSalas.DTOs.ReservaDTO;
import com.FinalTest.reservaDeSalas.Model.Reserva;
import com.FinalTest.reservaDeSalas.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;


    @PostMapping
    public ResponseEntity<Void> gravarReserva(@RequestBody ReservaDTO dto) {

        reservaService.fazerReserva(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/listar")
    public List<ReservaDTO> listarReservas() {
        return reservaService.listaReservas();
    }

}
