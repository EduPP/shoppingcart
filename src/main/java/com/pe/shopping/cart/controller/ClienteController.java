package com.pe.shopping.cart.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

import com.pe.shopping.cart.entity.Cliente;
import com.pe.shopping.cart.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Cliente>> getAllClientes() throws Exception {
		List<Cliente> clientes = clienteService.findAll();
		return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getCliente(@PathVariable Integer id) {
		Cliente cliente = clienteService.findClienteById(id);
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) throws Exception{
		Cliente clienteResponse = clienteService.saveCliente(cliente);
		return new ResponseEntity<Cliente>(clienteResponse,HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente,  @PathVariable Integer id) throws Exception{
		Cliente clienteEncontrado = clienteService.findClienteById(id);
		clienteEncontrado.setNombre(cliente.getNombre());
		clienteEncontrado.setApellido(cliente.getApellido());
		clienteEncontrado.setDni(cliente.getDni());
		clienteEncontrado.setTelefono(cliente.getTelefono());
		clienteEncontrado.setEmail(cliente.getEmail());
		
		Cliente clientResponse = clienteService.saveCliente(clienteEncontrado);
		return new ResponseEntity<Cliente>(clientResponse,HttpStatus.ACCEPTED);
	}
	
	
}
