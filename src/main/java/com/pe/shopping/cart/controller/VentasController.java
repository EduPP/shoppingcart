package com.pe.shopping.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pe.shopping.cart.entity.Cliente;
import com.pe.shopping.cart.entity.Venta;
import com.pe.shopping.cart.service.ClienteService;
import com.pe.shopping.cart.service.VentaService;

@RestController
@RequestMapping("/ventas")
public class VentasController {

	@Autowired
	private VentaService ventasService;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Venta>> getAllVentas() throws Exception {
		List<Venta> ventas = ventasService.findAll();
		return new ResponseEntity<List<Venta>>(ventas,HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getVenta(@PathVariable Integer id) {
		Venta venta = ventasService.findVentaId(id);
		return new ResponseEntity<Venta>(venta,HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) throws Exception{
		Venta ventaResponse = ventasService.saveVenta(venta);
		return new ResponseEntity<Venta>(ventaResponse,HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> updateVenta(@RequestBody Venta venta,  @PathVariable Integer id) throws Exception{
		Venta ventaEncontrada = ventasService.findVentaId(id);
		ventaEncontrada.setFecha(venta.getFecha());
		ventaEncontrada.setDetalleVentas(venta.getDetalleVentas());
		ventaEncontrada.setIdCliente(venta.getIdCliente());
		
		Venta ventaResponse = ventasService.saveVenta(ventaEncontrada);
		return new ResponseEntity<Venta>(ventaResponse,HttpStatus.ACCEPTED);
	}
	
}
