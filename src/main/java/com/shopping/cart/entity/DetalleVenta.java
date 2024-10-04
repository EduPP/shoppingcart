package com.shopping.cart.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
@Table(name="DETALLEVENTA")
public class DetalleVenta{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@OneToOne
	@JoinColumn(name = "PRODUCTOID", referencedColumnName = "ID")
	private Producto producto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VENTAID" , referencedColumnName = "ID")
	private Venta venta;
}
