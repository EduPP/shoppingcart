package com.pe.shopping.cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.pe.shopping.cart.dto.DetalleVentaDTO;
import com.pe.shopping.cart.dto.ProductoDTO;
import com.pe.shopping.cart.dto.VentaDTO;
import com.pe.shopping.cart.entity.DetalleVenta;
import com.pe.shopping.cart.entity.Venta;
import com.pe.shopping.cart.mapper.ProductoMapper;
import com.pe.shopping.cart.mapper.VentaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.pe.shopping.cart.dao.VentaDao;
import org.springframework.util.CollectionUtils;

@Service
@AllArgsConstructor
public class VentaServiceImp implements VentaService {

	private final VentaDao ventaDao;
	private final VentaMapper ventaMapper;
	private final ProductoMapper productoMapper;
	
	@Override
	public List<VentaDTO> findVentas() {
		return ventaDao.findAll()
				.stream()
				.map(venta -> {
					VentaDTO ventaDTO = ventaMapper.toDomain(venta);
					List<ProductoDTO> productoDTOS = new ArrayList<>();
					if(!CollectionUtils.isEmpty(venta.getDetalleVentas())){
						productoDTOS = venta.getDetalleVentas().stream()
															.map(DetalleVenta::getProducto)
															.map(productoMapper::toDomain)
															.collect(Collectors.toList());
					}
					DetalleVentaDTO detalles = DetalleVentaDTO.builder()
							.productos(productoDTOS).build();
					ventaDTO.setDetalleVenta(detalles);
					return ventaDTO;
				}).collect(Collectors.toList());
	}

	@Override
	public VentaDTO findVentaId(Long idVenta) {
		Optional<Venta> ventaOpt = ventaDao.findById(idVenta);
		return ventaOpt.map( ventaopt -> {
					VentaDTO ventaDTO = ventaMapper.toDomain(ventaopt);
					List<ProductoDTO> productoDTOS = new ArrayList<>();
					if(!CollectionUtils.isEmpty(ventaopt.getDetalleVentas())){
						productoDTOS = ventaopt.getDetalleVentas().stream()
								.map(DetalleVenta::getProducto)
								.map(productoMapper::toDomain)
								.collect(Collectors.toList());
					}
					DetalleVentaDTO detalles = DetalleVentaDTO.builder()
							.productos(productoDTOS).build();
					ventaDTO.setDetalleVenta(detalles);
					return ventaDTO;
				}).orElse(null);
	}

}
