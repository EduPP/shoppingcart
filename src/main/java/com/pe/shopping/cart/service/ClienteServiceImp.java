package com.pe.shopping.cart.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pe.shopping.cart.dao.ClienteDao;
import com.pe.shopping.cart.entity.Cliente;

@Service
public class ClienteServiceImp implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteDao.findAll();
	}

	@Override
	public Cliente findClienteById(Integer idCliente) {
		return clienteDao.findByIdCliente(idCliente);
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	public void deleteClienteById(Integer idCliente) {
		clienteDao.deleteById(idCliente);
	}

}
