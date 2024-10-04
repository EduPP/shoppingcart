package com.shopping.cart.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@EqualsAndHashCode
@Entity
@Table(name="VENTA")
public class Venta{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "CLIENTEID")
	private Integer idCliente;
	@Column(name = "FECHA")
	private Date fecha;
	@OneToMany(mappedBy = "venta", fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<DetalleVenta> detalleVentas;
}
