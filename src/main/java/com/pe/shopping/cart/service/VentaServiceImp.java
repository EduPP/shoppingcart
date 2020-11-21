package com.pe.shopping.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.shopping.cart.dao.VentaDao;
import com.pe.shopping.cart.entity.Venta;

@Service
public class VentaServiceImp implements VentaService {

	@Autowired
	private VentaDao ventaDao;
	
	@Override
	public List<Venta> findAll() {
		return (List<Venta>)ventaDao.findAll();
	}

	@Override
	public Venta findVentaId(Integer idVenta) {
		return ventaDao.findById(idVenta).get();
	}

	@Override
	public Venta saveVenta(Venta venta) {
		return ventaDao.save(venta);
	}

	@Override
	public void deleteVentaById(Integer idVenta) {
		ventaDao.deleteById(idVenta);

	}

}
