package com.shopping.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentaDTO {
    private Date fecha;
    private DetalleVentaDTO detalleVenta;
}
