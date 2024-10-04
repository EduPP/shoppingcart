package com.shopping.cart.controller;

import java.util.List;
import com.shopping.cart.dto.VentaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.shopping.cart.service.VentaService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ventas")
public class VentasController {

	private final VentaService ventasService;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<VentaDTO>> getAllVentas() {
		List<VentaDTO> ventas = ventasService.findVentas();
		return new ResponseEntity<>(ventas,HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<VentaDTO> getVenta(@PathVariable Long id) {
		VentaDTO venta = ventasService.findVentaId(id);
		return new ResponseEntity<>(venta,HttpStatus.OK);
	}
}
