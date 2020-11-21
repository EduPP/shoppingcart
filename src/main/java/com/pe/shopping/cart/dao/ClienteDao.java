package com.pe.shopping.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.shopping.cart.entity.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer>{

	public Cliente findByIdCliente(Integer idCliente);
}
