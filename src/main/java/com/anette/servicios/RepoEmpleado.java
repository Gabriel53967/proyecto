package com.anette.servicios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import com.anette.modelo.Empleado;

public interface RepoEmpleado extends CrudRepository<Empleado, Integer>{

	@Query(value= "SELECT* FROM Empleado WHERE correo=?1 AND claveacceso= ?2", nativeQuery=true)
	Empleado validarempleado (String correo, byte[] claveacceso);
	
}
