package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "O username é obrigatório")
    private String username;

    @NotBlank(message = "A senha é obrigatória")
    private String password;

    @NotBlank(message = "O email é obrigatório")
    private String email;
}
