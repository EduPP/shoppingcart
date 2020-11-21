package com.pe.shopping.cart.service;

import java.util.List;
import com.pe.shopping.cart.entity.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	public Producto findProductoById(Integer idProducto);
	public Producto saveProducto(Producto producto);
	public void deleteProductoById(Integer idProducto);
}
