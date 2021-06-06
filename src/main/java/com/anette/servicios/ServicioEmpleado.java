package com.anette.servicios;


import java.security.MessageDigest;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.anette.modelo.Empleado;


@Service
public class ServicioEmpleado {

	@Autowired
   private RepoEmpleado repoEmpleado;
   private String Mensaje;
   
   
   
   public String getMensaje() {
	   return Mensaje;
   }
   
   public void setMensaje(String mensaje) {
	   Mensaje= mensaje;
   }
   
   public boolean validarempleado(String correo, String clave) {
	  
	   Empleado usr= repoEmpleado.validarempleado(correo, encriptar(clave));
	   if(usr != null) {
		   
		
		   Mensaje = usr.getNombreemp() + "-" + usr.getCorreo();
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
   
   public boolean agregarempleado(Empleado u, String clave) {
	   try {
		   u.setClaveacceso(encriptar(clave));
		  
		   repoEmpleado.save(u);
		   
		   this.Mensaje ="Datos del usuario almacenados con exito";
		   return true;
	   }catch(Exception e) {
		   this.Mensaje="Error al registar al usuario";
		   return false;
	   }
   }
   
}
