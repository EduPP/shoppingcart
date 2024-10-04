package com.shopping.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.cart.entity.DetalleVenta;

public interface DetalleVentaDao extends JpaRepository<DetalleVenta, Integer>{

}
