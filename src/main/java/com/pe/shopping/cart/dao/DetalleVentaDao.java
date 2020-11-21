package com.pe.shopping.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pe.shopping.cart.entity.DetalleVenta;

public interface DetalleVentaDao extends JpaRepository<DetalleVenta, Integer>{

}
