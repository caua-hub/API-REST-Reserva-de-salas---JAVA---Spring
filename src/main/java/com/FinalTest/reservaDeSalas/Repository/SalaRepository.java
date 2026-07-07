package com.FinalTest.reservaDeSalas.Repository;

import com.FinalTest.reservaDeSalas.Model.Sala;
import com.FinalTest.reservaDeSalas.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala,Long> {

}
