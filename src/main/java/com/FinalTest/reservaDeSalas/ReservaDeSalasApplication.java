package com.FinalTest.reservaDeSalas;

import com.FinalTest.reservaDeSalas.Model.*;
import com.FinalTest.reservaDeSalas.Service.ReservaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ReservaDeSalasApplication{

    public static void main(String[] args) {
		SpringApplication.run(ReservaDeSalasApplication.class, args);
	}
}
