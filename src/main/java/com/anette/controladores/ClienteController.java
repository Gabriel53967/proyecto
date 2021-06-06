package com.anette.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.anette.servicios.ServicioCliente;

import com.anette.modelo.Cliente;

@Controller
public class ClienteController {
@Autowired
ServicioCliente servicioCliente;



  @GetMapping("/Inicio/inicio") public String inicio() { return
  "Inicio/inicio"; }
 

@GetMapping(path={"/usuario/validar", "/"})

public String validar(){
	return "usuario/validar";
}
@PostMapping("/usuario/validar")
public String agregar(@RequestParam("username") String  correo,
		@RequestParam("password") String clave, Model modelo) {
	
	
	return"redirect:/Inicio/inicio";	
			
}


@GetMapping("/usuario/agregar")
public String agregar(Model modelo) {
	modelo.addAttribute("cliente", new Cliente());
	return "usuario/agregar";
}

@PostMapping("/usuario/agregar")
public String agregar(Model modelo, @ModelAttribute Cliente user, @RequestParam("clave") String clave, HttpSession sesion) {
	boolean res = servicioCliente.agregar(user, clave, sesion);
	if(res) {
		return "redirect:/Inicio/reservacion";
	}
	modelo.addAttribute("error",servicioCliente.getMensaje());
	return "usuario/agregar";
	
}

@GetMapping("/usuario/salir")
public String salir(HttpSession sesion) {
	SecurityContextHolder.clearContext();
	sesion.invalidate();
	return "redirect:/";
}
}