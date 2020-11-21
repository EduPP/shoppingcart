package com.pe.shopping.cart.service;

import java.util.List;
import com.pe.shopping.cart.entity.Venta;

public interface VentaService {
	
	public List<Venta> findAll();
	public Venta findVentaId(Integer idVenta);
	public Venta saveVenta(Venta venta);
	public void deleteVentaById(Integer idVenta);

}
