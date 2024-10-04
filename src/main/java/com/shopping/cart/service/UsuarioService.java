package com.shopping.cart.service;

import com.shopping.cart.entity.Usuario;

public interface UsuarioService {

	Usuario findByUsername(String username);
}
