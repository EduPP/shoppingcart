package com.shopping.cart.mapper;

import com.shopping.cart.dto.RoleDTO;
import com.shopping.cart.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    RoleDTO toDomain(Role role);

}
