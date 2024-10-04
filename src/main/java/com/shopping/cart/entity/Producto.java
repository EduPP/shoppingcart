package com.shopping.cart.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode
@Entity
@Table(name="PRODUCTO")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "CODIGOPRODUCTO")
	private String codigoProducto;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "PRECIO")
	private Integer precio;

	
}
