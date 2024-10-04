package com.shopping.cart.mapper;

import com.shopping.cart.dto.UserDTO;
import com.shopping.cart.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "username" , target = "username")
    @Mapping(source = "enabled" , target = "enabled")
    @Mapping(source = "nombre" , target = "nombre")
    @Mapping(source = "apellido" , target = "apellido")
    @Mapping(source = "email" , target = "email")
    UserDTO toDomain(Usuario usuario);
}
