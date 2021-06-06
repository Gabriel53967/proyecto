package com.anette.servicios;


import java.security.MessageDigest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.anette.modelo.Cliente;


@Service
public class ServicioCliente {

	@Autowired
   private RepoCliente repoCliente;
   private String Mensaje;
   
   
   
   public String getMensaje() {
	   return Mensaje;
   }
   
   public void setMensaje(String mensaje) {
	   Mensaje = mensaje;
   }
   
   public boolean validar(String correo, String clave, HttpSession sesion) {
	  
	   Cliente usr= repoCliente.validar(correo, encriptar(clave));
	   if(usr != null) {
		   sesion.setAttribute("iduser", usr.getId());
		
		   Mensaje = usr.getNombrecli() + "-" + usr.getCorreo();
		   return true;
	   }
	   Mensaje = "Datos de acceso incorrectos";
	   return false;
   }
	   
   
   private byte[] encriptar (String clave) {
	   try {
		   MessageDigest digest= MessageDigest.getInstance("SHA-1");
		   digest.reset();
		   digest.update(clave.getBytes("utf8"));
		   return digest.digest();
	   }catch (Exception e) {
		   return null;
	   }
   }
   
   public boolean agregar(Cliente u, String clave, HttpSession sesion) {
	   try {
		   u.setClaveacceso(encriptar(clave));
		  
		   repoCliente.save(u);
		   sesion.setAttribute("iduser", u.getId());
		   this.Mensaje ="Datos del usuario almacenados con exito";
		   return true;
	   }catch(Exception e) {
		   this.Mensaje="Error al registar al usuario";
		   return false;
	   }
   }
   
   public Cliente buscar(int id) {
	   try {
		   Cliente usuario = repoCliente.findById(id).get();
		   return usuario == null? new Cliente() : usuario;
	   }catch(Exception e) {
		   this.Mensaje="No se pudo realizar la busqueda del usuario";
		   return null;
	   }
   }
   

}