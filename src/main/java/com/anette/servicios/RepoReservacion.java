package com.anette.servicios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.anette.modelo.Reserva;

public interface RepoReservacion extends CrudRepository <Reserva, Integer> {
	@Query(value = "Select * FROM reserva", nativeQuery = true)
	ArrayList<Reserva> todos();
}
