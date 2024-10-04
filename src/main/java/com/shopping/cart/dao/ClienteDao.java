package com.shopping.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.cart.entity.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long>{

}
