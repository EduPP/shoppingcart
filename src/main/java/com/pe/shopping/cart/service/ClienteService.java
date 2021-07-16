package com.pe.shopping.cart.service;

import java.util.List;
import com.pe.shopping.cart.dto.ClienteDTO;

public interface ClienteService{
	
	List<ClienteDTO> findClientes();
	ClienteDTO findClienteById(Long idCliente);
	ClienteDTO saveCliente(ClienteDTO cliente);
	void deleteClienteById(Long idCliente);
}
