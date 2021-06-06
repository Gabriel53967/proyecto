package com.anette.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anette.modelo.Reserva;


@Service
public class ServicioReservacion {
@Autowired
private RepoReservacion repoReservacion;
private String Mensaje;

public String getMensaje() {
	return Mensaje;
}

public void setMensaje(String mensaje) {
	Mensaje=mensaje;
}

public boolean agregar(Reserva reserva){
	try {
		repoReservacion.save(reserva);
		this.Mensaje ="La reservacion se ha registrado con exito";
		return true;
	}catch (Exception e) {
		this.Mensaje ="Error al registar la reserva";
		return false;
	}
}

public Iterable<Reserva> verTodos(){
	try {
		this.Mensaje = "";
		return repoReservacion.findAll();
	}catch(Exception e) {
		this.Mensaje = e.getMessage();
		return null;
	}
}


public Reserva buscar(int id) {
	try {
		this.Mensaje = "";
		Reserva reserva = repoReservacion.findById(id).get();
		return reserva == null ? new Reserva() : reserva;
		
	}catch(Exception e) {
		this.Mensaje = e.getMessage();
		return null;
	}
}
}
