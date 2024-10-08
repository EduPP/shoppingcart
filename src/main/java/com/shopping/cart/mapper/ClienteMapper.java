package com.shopping.cart.mapper;

import com.shopping.cart.dto.ClienteDTO;
import com.shopping.cart.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

    ClienteDTO toDomain(Cliente cliente);

    Cliente toEntity(ClienteDTO clienteDTO);
}
