package com.pe.shopping.cart.controller;

import java.util.List;
import com.pe.shopping.cart.dto.ClienteDTO;
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
import com.pe.shopping.cart.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ClienteDTO>> getAllClientes() {
		List<ClienteDTO> clientes = clienteService.findClientes();
		return new ResponseEntity<>(clientes,HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ClienteDTO> getCliente(@PathVariable Long id) {
		ClienteDTO cliente = clienteService.findClienteById(id);
		return new ResponseEntity<>(cliente,HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO cliente){
		ClienteDTO clienteResponse = clienteService.saveCliente(cliente);
		return new ResponseEntity<>(clienteResponse,HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ClienteDTO> updateCliente(@RequestBody ClienteDTO cliente,  @PathVariable Long id){
		ClienteDTO clienteEncontrado = clienteService.findClienteById(id);
		clienteEncontrado.setNombre(cliente.getNombre());
		clienteEncontrado.setApellido(cliente.getApellido());
		clienteEncontrado.setDni(cliente.getDni());
		clienteEncontrado.setTelefono(cliente.getTelefono());
		clienteEncontrado.setEmail(cliente.getEmail());

		ClienteDTO clientResponse = clienteService.saveCliente(clienteEncontrado);
		return new ResponseEntity<>(clientResponse,HttpStatus.ACCEPTED);
	}
	
	
}
