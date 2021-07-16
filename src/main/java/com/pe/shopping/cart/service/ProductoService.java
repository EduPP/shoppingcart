package com.pe.shopping.cart.service;


import com.pe.shopping.cart.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {

	List<ProductoDTO> findProductos();
	ProductoDTO findProductoByCodigo(String codigo);
	ProductoDTO saveProducto(ProductoDTO producto);
	void deleteProductoById(String codigo);
}
