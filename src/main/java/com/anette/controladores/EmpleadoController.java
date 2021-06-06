package com.anette.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anette.modelo.Empleado;
import com.anette.servicios.ServicioEmpleado;

@Controller
public class EmpleadoController {

	
	@Autowired
	ServicioEmpleado servicioEmpleado;


@GetMapping("/usuario/validarempleado")

public String validar(){
	return "usuario/validarempleado";
}

@PostMapping("/usuario/validarempleado")
public String agregar(@RequestParam("correo")String correo,
		@RequestParam("clave") String clave, Model modelo) {
	boolean res= servicioEmpleado.validarempleado(correo, clave);
	if (res) {
		return"redirect:/usuario/reservacion";	
	}
	modelo.addAttribute("error", servicioEmpleado.getMensaje());
	modelo.addAttribute("correo", correo);
	modelo.addAttribute("clave",clave);
	
	return"/usuario/validarempleado";	
			
}


@GetMapping("/usuario/agregarempleado")
public String agregarempleado(Model modelo) {
	modelo.addAttribute("empleado", new Empleado());
	return "usuario/agregarempleado";
}

@PostMapping("/usuario/agregarempleado")
public String agregarempleado(Model modelo, @ModelAttribute Empleado user, @RequestParam("clave") String clave) {
	boolean res = servicioEmpleado.agregarempleado(user, clave);
	if(res) {
		return "redirect:/Inicio/inicio";
	}
	modelo.addAttribute("error",servicioEmpleado.getMensaje());
	return "/usuario/agregarempleado";
	
}
}


