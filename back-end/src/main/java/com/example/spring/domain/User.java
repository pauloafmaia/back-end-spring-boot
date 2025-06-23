package com.example.spring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TBUSER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Column(name = "user_username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "user_password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "user_email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name = "user_last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}



