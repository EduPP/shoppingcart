package com.shopping.cart.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private Boolean enabled;
    private String nombre;
    private String apellido;
    private String email;
    private List<RoleDTO> roles;
}
