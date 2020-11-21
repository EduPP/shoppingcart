package com.pe.shopping.cart.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalleventa")
public class DetalleVenta implements Serializable{

	private static final long serialVersionUID = 6954379338795405248L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "iddetalleventa")
	private Integer idDetalleVenta;
	
	@Column(name = "idproducto")
	private Integer idProducto;

	public Integer getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Integer idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	@Override
	public String toString() {
		return "DetalleVenta [idDetalleVenta=" + idDetalleVenta + ", idProducto=" + idProducto + "]";
	}

	
	
}
