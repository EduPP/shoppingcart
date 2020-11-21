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
import com.pe.shopping.cart.entity.Producto;
import com.pe.shopping.cart.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Producto>> getAllProductos() throws Exception {
		List<Producto> productos = productoService.findAll();
		return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getProducto(@PathVariable Integer id) {
		Producto producto = productoService.findProductoById(id);
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Producto> createVenta(@RequestBody Producto producto) throws Exception{
		Producto productoResponse = productoService.saveProducto(producto);
		return new ResponseEntity<Producto>(productoResponse,HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> updateVenta(@RequestBody Producto producto,  @PathVariable Integer id) throws Exception{
		Producto productoEncontrado = productoService.findProductoById(id);
		productoEncontrado.setNombre(producto.getNombre());
		productoEncontrado.setPrecio(producto.getPrecio());
		
		Producto productoResponse = productoService.saveProducto(productoEncontrado);
		return new ResponseEntity<Producto>(productoResponse,HttpStatus.ACCEPTED);
	}
}
