package com.pe.shopping.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pe.shopping.cart.dao.ProductoDao;
import com.pe.shopping.cart.entity.Producto;

@Service
public class ProductoServiceImp implements ProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public List<Producto> findAll() {
		return (List<Producto>)productoDao.findAll();
	}

	@Override
	public Producto findProductoById(Integer idProducto) {
		return productoDao.findById(idProducto).get();
	}

	@Override
	public Producto saveProducto(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public void deleteProductoById(Integer idProducto) {
		productoDao.deleteById(idProducto);

	}

}
