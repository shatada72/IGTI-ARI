package com.sidneyhatada.demo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sidneyhatada.demo.domain.Cliente;
import com.sidneyhatada.demo.exception.RecursoNotFoundException;
import com.sidneyhatada.demo.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Acme AP Cliente Service")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@ApiOperation(value = "Exibe a lista de clientes")
	//Controle de versão explicito na URI
	@GetMapping("v1/clientes")
	public List<Cliente> getAllClientes()
	{
		
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			listaClientes = (ArrayList<Cliente>) clienteRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RecursoNotFoundException ("Erro ao recuperar lista de clientes");
		}
		
			
		return listaClientes;
	}
	
	
	
	@ApiOperation(value = "Consulta um cliente pelo CPF")
	@GetMapping("v1/clientes/{cpf}")
	public Optional<Cliente> getClienteByCpf(@PathVariable String cpf)
	{

		Optional<Cliente> cliente = null;
		
		try {
			cliente = clienteRepository.findByCpf(cpf);
			
			if (cliente.get() == null)
				throw new RecursoNotFoundException ("CPF inválido - " + cpf);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RecursoNotFoundException ("CPF inválido - " + cpf);
		}
		
		
		
		return cliente;
	}
	

	
	@ApiOperation(value = "Cadastrar um novo cliente")
	@PostMapping("v1/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> criarCliente(@RequestBody Cliente cliente)
	{
		Cliente clienteCriado;
		
		URI location = null;
		
		
		try {
			clienteCriado = clienteRepository.save(cliente);
			
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clienteCriado.getId()).toUri();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RecursoNotFoundException ("Erro ao cadastrar cliente CPF: " + cliente.getCpf());
		}
		return ResponseEntity.created(location).build();
	}

	
	
}