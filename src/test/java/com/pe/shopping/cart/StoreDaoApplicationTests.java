package com.pe.shopping.cart;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pe.shopping.cart.dao.ClienteDao;
import com.pe.shopping.cart.dao.DetalleVentaDao;
import com.pe.shopping.cart.dao.ProductoDao;
import com.pe.shopping.cart.dao.VentaDao;
import com.pe.shopping.cart.entity.Cliente;
import com.pe.shopping.cart.entity.DetalleVenta;
import com.pe.shopping.cart.entity.Producto;
import com.pe.shopping.cart.entity.Venta;

@SpringBootTest
class ShoppingCartDaoApplicationTests {

	
	private static final Logger log = LoggerFactory.getLogger(ShoppingCartDaoApplicationTests.class);

	
	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private VentaDao ventaDao;
	
	@Autowired
	private ProductoDao productoDao;
	
	@Autowired
	private DetalleVentaDao detalleVentaDao;
	
	@Test
	void clienteFindAllTest() {
		List<Cliente> clientes = clienteDao.findAll();
		log.info(clientes.toString());
		assertNotNull(clientes);		
		
	}
	
	@Test
	void clienteTest() {
		Cliente cliente = clienteDao.findById(1L).get();
		log.info(cliente.toString());
		assertNotNull(cliente);		
		
	}
	
	@Test
	void ventaTest() {
		Venta venta = ventaDao.findById(1L).get();
		log.info(venta.toString());
		assertNotNull(venta);		
		
	}
	/*
	@Test
	void productoTest() {
		Producto producto = productoDao.findById(1).get();
		log.info(producto.toString());
		assertNotNull(producto);		
		
	}

	
	@Test
	void DetalleVentaTest() {
		DetalleVenta detalleVenta = detalleVentaDao.findById(1).get();
		log.info(detalleVenta.toString());
		assertNotNull(detalleVenta);		
		
	}
*/
}
