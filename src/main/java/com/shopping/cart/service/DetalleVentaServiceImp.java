package com.shopping.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.dao.DetalleVentaDao;
import com.shopping.cart.entity.DetalleVenta;

@Service
public class DetalleVentaServiceImp implements DetalleVentaService {

	@Autowired
	private DetalleVentaDao detalleVentaDao;
	
	@Override
	public List<DetalleVenta> findAll() {
		return (List<DetalleVenta>)detalleVentaDao.findAll();
	}

	@Override
	public DetalleVenta findDetalleVentaById(Integer idDetalleVenta) {
		return detalleVentaDao.findById(idDetalleVenta).get();
	}

	@Override
	public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) {
		return detalleVentaDao.save(detalleVenta);
	}

	@Override
	public void deleteDetalleVentaById(Integer idDetalleVenta) {
		detalleVentaDao.deleteById(idDetalleVenta);

	}

}
