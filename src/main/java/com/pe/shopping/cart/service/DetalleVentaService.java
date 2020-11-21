package com.pe.shopping.cart.service;

import java.util.List;
import com.pe.shopping.cart.entity.DetalleVenta;

public interface DetalleVentaService {

	public List<DetalleVenta> findAll();
	public DetalleVenta findDetalleVentaById(Integer idDetalleVenta);
	public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta);
	public void deleteDetalleVentaById(Integer idDetalleVenta);
}
