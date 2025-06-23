package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TBEMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Column(name = "employee_name", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "employee_cpf", nullable = false, unique = true)
    private String cpf;

    @NotNull
    @Column(name = "employee_gender")
    private String gender;

    @NotNull
    @Column(name = "employee_birth")
    private Date birth;

    @NotNull
    @Email
    @Column(name = "employee_email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "employee_phone")
    private Long phone;

    @NotNull
    @Column(name = "employee_address")
    private String address;

    @NotNull
    @Column(name = "employee_salary")
    private Long salary;

    @Column(name = "employee_create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name = "employee_last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}



