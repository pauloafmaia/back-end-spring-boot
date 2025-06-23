package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String gender;

    @NotNull
    @Past
    private Date birth;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private Long phone;

    @NotBlank
    private String address;

    @NotNull
    private Long salary;
}
