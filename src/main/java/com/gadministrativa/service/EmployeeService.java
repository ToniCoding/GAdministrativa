package com.gadministrativa.service;

import com.gadministrativa.dto.EmployeeRequestDTO;
import com.gadministrativa.entity.Employee;
import com.gadministrativa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee newEmployee = new Employee();
        newEmployee.setName(employeeRequestDTO.getName());
        newEmployee.setSurname(employeeRequestDTO.getSurname());
        newEmployee.setJoinDate(LocalDateTime.now());
        newEmployee.setDepartment(null);

        return employeeRepository.save(newEmployee);
    }
}
