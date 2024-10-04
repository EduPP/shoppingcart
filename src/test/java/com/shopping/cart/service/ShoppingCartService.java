package com.shopping.cart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShoppingCartService {

	private static final Logger log = LoggerFactory.getLogger(ShoppingCartService.class);

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	VentaService ventaService;
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	DetalleVentaService detalleVentaService;
	
	/*
	@Test
	void clienteFindAllTest() {
		List<Cliente> clientes = clienteService.findAll();
		log.info(clientes.toString());
		assertNotNull(clientes);
	}
	
	@Test
	void clienteSaveTest() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Jorge");
		cliente.setApellido("Gonzales");
		cliente.setDni(44556677);
		cliente.setTelefono(987537451);
		cliente.setEmail("jgonzales@mail.com");
	
		Cliente clienteGuardado = clienteService.saveCliente(cliente);
		log.info(clienteGuardado.toString());
		assertNotNull(clienteGuardado);
	}
*/
	/*
	@Test
	void ventaFindAllTest() {
		List<Venta> ventas = ventaService.findAll();
		log.info(ventas.toString());
		assertNotNull(ventas);
	}
	
	@Test
	void ProductosFindAllTest() {
		List<Producto> producto = productoService.findAll();
		log.info(producto.toString());
		assertNotNull(producto);
	}
	
	@Test
	void DetallesFindAllTest() {
		List<DetalleVenta> detalleVentas = detalleVentaService.findAll();
		log.info(detalleVentas.toString());
		assertNotNull(detalleVentas);
	}*/
}
