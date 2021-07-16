package com.pe.shopping.cart.service;

import java.util.List;
import com.pe.shopping.cart.entity.DetalleVenta;

public interface DetalleVentaService {

	List<DetalleVenta> findAll();
	DetalleVenta findDetalleVentaById(Integer idDetalleVenta);
	DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta);
	void deleteDetalleVentaById(Integer idDetalleVenta);
}
