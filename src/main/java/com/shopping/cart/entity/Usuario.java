package com.shopping.cart.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "USUARIOS")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "USERNAME", unique = true, length = 20)
	private String username;
	@Column(name = "PASSWORD",length = 60)
	private String password;
	@Column(name = "ENABLED")
	private Boolean enabled;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO")
	private String apellido;
	@Column(name = "EMAIL",unique = true)
	private String email;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="USUARIOS_ROLES", joinColumns= @JoinColumn(name="USUARIOID"),
	inverseJoinColumns = @JoinColumn(name="ROLEID"),
	uniqueConstraints = {@UniqueConstraint(columnNames= {"USUARIOID", "ROLEID"})})
	private List<Role> roles;
}
