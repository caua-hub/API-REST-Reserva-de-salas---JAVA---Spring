package com.FinalTest.reservaDeSalas.DTOs;

import java.time.LocalDateTime;

public record ReservaDTO(
        Long usuarioId,
        Long salaId,
        LocalDateTime inicio,
        LocalDateTime fim,
        int pessoas)
{

}
