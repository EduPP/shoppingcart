package com.shopping.cart;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopping.cart.dao.ClienteDao;
import com.shopping.cart.dao.DetalleVentaDao;
import com.shopping.cart.dao.ProductoDao;
import com.shopping.cart.dao.VentaDao;
import com.shopping.cart.entity.Cliente;
import com.shopping.cart.entity.Venta;

@SpringBootTest
class ShoppingCartDaoApplicationTests {
	
	private static final Logger log = LoggerFactory.getLogger(ShoppingCartDaoApplicationTests.class);

	@Mock
	private ClienteDao clienteDao;
	
	@Mock
	private VentaDao ventaDao;
	
	@Mock
	private ProductoDao productoDao;
	
	@Mock
	private DetalleVentaDao detalleVentaDao;

	/*
	@Test
	void clienteFindAllTest() {
		when(clienteDao.findAll()).thenReturn(List.of(
				Cliente.builder()
						.id(1L)
						.dni(342344542)
						.email("alfre@mail.com")
						.nombre("Alfredo")
						.apellido("Gonzales")
						.telefono(45242524)
						.build(),
				Cliente.builder()
						.id(2L)
						.dni(34236452)
						.email("Nahuel@mail.com")
						.nombre("Nahuel")
						.apellido("Barcena")
						.telefono(532452)
						.build(),
				Cliente.builder()
						.id(3L)
						.dni(783436452)
						.email("Wendy@mail.com")
						.nombre("Wendy")
						.apellido("Lazaro")
						.telefono(78645534)
						.build()
				));
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
