package com.pe.shopping.cart.service;

import java.util.List;
import com.pe.shopping.cart.dto.VentaDTO;

public interface VentaService {
	
	List<VentaDTO> findVentas();
	VentaDTO findVentaId(Long idVenta);
}
