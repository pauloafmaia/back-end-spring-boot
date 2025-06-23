package com.example.spring.repository;

import com.example.spring.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByCpf(String cpf);
}
