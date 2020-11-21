package com.pe.shopping.cart.service;

import java.util.List;
import com.pe.shopping.cart.entity.Cliente;


public interface ClienteService{
	
	public List<Cliente> findAll();
	public Cliente findClienteById(Integer idCliente);
	public Cliente saveCliente(Cliente cliente);
	public void deleteClienteById(Integer idCliente);
	

}
