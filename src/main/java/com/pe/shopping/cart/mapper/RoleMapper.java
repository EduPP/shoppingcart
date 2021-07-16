package com.pe.shopping.cart.mapper;

import com.pe.shopping.cart.dto.RoleDTO;
import com.pe.shopping.cart.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    RoleDTO toDomain(Role role);

}
