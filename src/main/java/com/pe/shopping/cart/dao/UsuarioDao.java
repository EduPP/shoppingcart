package com.pe.shopping.cart.dao;

import org.springframework.data.repository.CrudRepository;
import com.pe.shopping.cart.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{

	Usuario findByUsername(String username);
}
