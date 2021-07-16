package com.pe.shopping.cart.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.pe.shopping.cart.dto.ClienteDTO;
import com.pe.shopping.cart.entity.Cliente;
import com.pe.shopping.cart.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.pe.shopping.cart.dao.ClienteDao;

@Service
@RequiredArgsConstructor
public class ClienteServiceImp implements ClienteService {

	private final ClienteDao clienteDao;
	private final ClienteMapper clienteMapper;

	@Override
	public List<ClienteDTO> findClientes() {
		return clienteDao.findAll()
				.stream()
				.map(clienteMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public ClienteDTO findClienteById(Long idCliente) {
		Optional<Cliente> clienteOpt = clienteDao.findById(idCliente);
		return clienteOpt.map(clienteMapper::toDomain).orElse(null);
	}

	@Override
	public ClienteDTO saveCliente(ClienteDTO clienteDTO) {
		Cliente cliente = clienteMapper.toEntity(clienteDTO);
		return clienteMapper.toDomain(clienteDao.save(cliente));
	}

	@Override
	public void deleteClienteById(Long idCliente) {
		clienteDao.deleteById(idCliente);
	}

}
