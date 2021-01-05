package br.com.bancohelloworld.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancohelloworld.model.Cliente;
import br.com.bancohelloworld.repository.ClienteRepository;

@RestController // habilta o serviço RestFull
@RequestMapping(value = "/cliente") // Url Mapeada
public class aplicacaocontroller {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired // fornece controle sobre onde e como a ligação entre os beans deve ser
				// realizada
	private ClienteRepository clienteRepository;

	// Serviço Restfull

	@PostMapping(value = "/cadastrar", produces = "application/json")
	public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente) {
		
		Cliente usuarioSalvo = clienteRepository.save(cliente); // Grava no banco de dados e retorna o objeto no
		try {
			return new ResponseEntity<Cliente>(usuarioSalvo, HttpStatus.CREATED);// Retorna o objeto e o status da requisição estado persistente

		} catch (Exception e) {
				e.getMessage();
				
		}
		return new ResponseEntity<Cliente>(usuarioSalvo, HttpStatus.BAD_REQUEST);

	}
}
