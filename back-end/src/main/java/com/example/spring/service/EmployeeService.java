package com.example.spring.service;

import com.example.spring.domain.Employee;
import com.example.spring.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee create(Employee employee) {
        if (employeeRepository.existsByCpf(employee.getCpf())) {
            throw new EntityNotFoundException("Employee with CPF " + employee.getCpf() + " already exists");
        }
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee update(Long id, Employee updatedEmployee) {
        Employee existingEmployee = findById(id);

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setGender(updatedEmployee.getGender());
        existingEmployee.setBirth(updatedEmployee.getBirth());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setPhone(updatedEmployee.getPhone());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        existingEmployee.setSalary(updatedEmployee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    public void delete(Long id) {
        Employee employee = findById(id);
        employeeRepository.delete(employee);
    }
}
