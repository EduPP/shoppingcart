package com.shopping.cart.dao;

import org.springframework.data.repository.CrudRepository;
import com.shopping.cart.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{

	Usuario findByUsername(String username);
}
