package com.shopping.cart.controller;

import java.util.List;
import com.shopping.cart.dto.ProductoDTO;
import lombok.RequiredArgsConstructor;
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
import com.shopping.cart.service.ProductoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/productos")
public class ProductoController {

	private final ProductoService productoService;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ProductoDTO>> getAllProductos() {
		List<ProductoDTO> productos = productoService.findProductos();
		return new ResponseEntity<>(productos,HttpStatus.OK);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ProductoDTO> getProducto(@PathVariable String codigo) {
		ProductoDTO producto = productoService.findProductoByCodigo(codigo);
		return new ResponseEntity<>(producto,HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProductoDTO> createVenta(@RequestBody ProductoDTO productoDTO) {
		ProductoDTO productoResponse = productoService.saveProducto(productoDTO);
		return new ResponseEntity<>(productoResponse,HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProductoDTO> updateVenta(@RequestBody ProductoDTO productoDTO,  @PathVariable("id") String codigo){
		ProductoDTO productoEncontrado = productoService.findProductoByCodigo(codigo);
		productoEncontrado.setCodigoProducto(productoDTO.getCodigoProducto());
		productoEncontrado.setNombre(productoDTO.getNombre());
		productoEncontrado.setPrecio(productoDTO.getPrecio());

		ProductoDTO productoResponse = productoService.saveProducto(productoEncontrado);
		return new ResponseEntity<>(productoResponse,HttpStatus.ACCEPTED);
	}
}
