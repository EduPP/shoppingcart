package com.pe.shopping.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.shopping.cart.entity.Producto;

public interface ProductoDao extends JpaRepository<Producto, Integer>{

}
