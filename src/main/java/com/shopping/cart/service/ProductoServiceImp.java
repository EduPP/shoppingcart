package com.shopping.cart.service;

import java.util.List;
import java.util.stream.Collectors;
import com.shopping.cart.dto.ProductoDTO;
import com.shopping.cart.mapper.ProductoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.shopping.cart.dao.ProductoDao;
import com.shopping.cart.entity.Producto;

@Service
@AllArgsConstructor
public class ProductoServiceImp implements ProductoService {

	private final ProductoDao productoDao;
	private final ProductoMapper productoMapper;
	
	@Override
	public List<ProductoDTO> findProductos() {
		return productoDao.findAll()
				.stream()
				.map(productoMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public ProductoDTO findProductoByCodigo(String codigo) {
		return productoDao.findByCodigoProducto(codigo)
				.map(productoMapper::toDomain).orElse(null);
	}

	@Override
	public ProductoDTO saveProducto(ProductoDTO productoDTO) {
		Producto producto = productoMapper.toEntity(productoDTO);
		return productoMapper.toDomain(productoDao.save(producto));
	}

	@Override
	public void deleteProductoById(String codigo) {
		productoDao.deleteByCodigoProducto(codigo);
	}

}
