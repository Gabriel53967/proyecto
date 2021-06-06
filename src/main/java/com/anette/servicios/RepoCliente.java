package com.anette.servicios;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import com.anette.modelo.Cliente;

public interface RepoCliente extends CrudRepository<Cliente, Integer>{

	@Query(value= "SELECT* FROM cliente WHERE correo=?1 AND claveacceso= ?2", nativeQuery=true)
	Cliente validar(String correo, byte[] claveacceso);
	
}
