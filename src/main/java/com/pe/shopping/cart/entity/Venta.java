package com.pe.shopping.cart.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="venta")
public class Venta implements Serializable{

	private static final long serialVersionUID = -177053747601200238L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idventa")
	private Integer idVenta;
	
	@Column(name = "idcliente")
	private Integer idCliente;
	private Date fecha;
	
	@OneToMany(fetch=FetchType.EAGER,cascade= CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "idventa")
	private List<DetalleVenta> detalleVentas;

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<DetalleVenta> getDetalleVentas() {
		return detalleVentas;
	}

	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", idCliente=" + idCliente + ", fecha=" + fecha + ", detalleVentas="
				+ detalleVentas + "]";
	}

	
}
