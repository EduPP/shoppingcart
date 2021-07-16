package com.pe.shopping.cart.mapper;

import com.pe.shopping.cart.dto.VentaDTO;
import com.pe.shopping.cart.entity.Venta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface VentaMapper {

   @Mapping(source = "fecha" , target = "fecha")
   VentaDTO toDomain(Venta venta);
}
