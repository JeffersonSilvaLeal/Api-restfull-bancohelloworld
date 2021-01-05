package br.com.bancohelloworld.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bancohelloworld.model.Cliente;

@Repository // definir uma classe como pertencente à camada de persistência.
										      //Classe de modelo - Tipo de Primary Key
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	
}
