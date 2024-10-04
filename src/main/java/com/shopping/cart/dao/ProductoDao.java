package com.shopping.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.cart.entity.Producto;

import java.util.Optional;

public interface ProductoDao extends JpaRepository<Producto, Long>{

    Optional<Producto> findByCodigoProducto(String codigoProducto);
    void deleteByCodigoProducto(String codigoProducto);
}
