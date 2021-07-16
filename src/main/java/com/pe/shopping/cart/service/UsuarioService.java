package com.pe.shopping.cart.service;

import com.pe.shopping.cart.entity.Usuario;

public interface UsuarioService {

	Usuario findByUsername(String username);
}
