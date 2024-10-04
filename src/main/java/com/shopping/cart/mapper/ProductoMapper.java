package com.shopping.cart.mapper;

import com.shopping.cart.dto.ProductoDTO;
import com.shopping.cart.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductoMapper {

    ProductoDTO toDomain(Producto producto);

    Producto toEntity(ProductoDTO productoDTO);
}
