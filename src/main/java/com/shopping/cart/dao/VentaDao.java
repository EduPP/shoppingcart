package com.shopping.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.cart.entity.Venta;

public interface VentaDao extends JpaRepository<Venta, Long>{

}
