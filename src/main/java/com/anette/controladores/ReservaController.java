package com.anette.controladores;






import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;


import com.anette.modelo.Reserva;

import com.anette.modelo.Cliente;
//import com.anette.modelo.Empleado;

import com.anette.servicios.ServicioReservacion;
import com.anette.servicios.ServicioCliente;
//import com.anette.servicios.ServicioEmpleado;
@Controller
public class ReservaController {
	@Autowired
	ServicioCliente servicioCliente;
	//@Autowired
	//ServicioEmpleado servicioEmpleado;
	@Autowired
	ServicioReservacion servicioReservacion;	
	
	@GetMapping("/Inicio/reservacion")
	public String reservacion(Model modelo) {
		Iterable<Reserva> reservas = servicioReservacion.verTodos();
		
		if(reservas != null && reservas.iterator().hasNext()) {
			modelo.addAttribute("reservas", reservas);
		}
		else
		{
			modelo.addAttribute("error", "No existe ninguna reserva");
		}
		modelo.addAttribute("reserva", new Reserva());
		if(!servicioReservacion.getMensaje().equals("")) {
			modelo.addAttribute("error", servicioReservacion.getMensaje());
		}
		return "Inicio/reservacion";
	}
	
	@PostMapping("/Inicio/agregar")
	public String agregar(Model modelo, @ModelAttribute Reserva reserva,
			//@RequestParam(value="habitacion", required = true) int habitacion, 
			 HttpSession sesion) {
	
		
		//String dateInString = "7-Jun-2013"; Date date = formatter.parse(dateInString);--
		
		int isuser = Integer.parseInt(sesion.getAttribute("iduser").toString());	
		Cliente autor = servicioCliente.buscar(isuser);
		if(autor == null || autor.getId()== 0)
			modelo.addAttribute("error", servicioCliente.getMensaje());
		
		else {
		
			
			reserva.setCliente(autor);
			
			if(!servicioReservacion.agregar(reserva));
				modelo.addAttribute("error", servicioReservacion.getMensaje());
		}
		 return "redirect:/Inicio/reservacion";
	}
	
}