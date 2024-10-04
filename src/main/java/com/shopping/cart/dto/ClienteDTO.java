package com.shopping.cart.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private Integer telefono;
    private String email;
}
