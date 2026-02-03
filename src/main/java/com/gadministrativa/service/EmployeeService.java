package com.gadministrativa.service;

import com.gadministrativa.dto.EmployeeRequestDTO;
import com.gadministrativa.entity.Employee;
import com.gadministrativa.exception.EmployeeDoesNotExist;
import com.gadministrativa.exception.FieldChangeNotAllowed;
import com.gadministrativa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

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

    public Employee getEmployee(Long id) {
        Employee employee =  employeeRepository.findEmployeeById(id);

        if (employee == null) {
            throw new EmployeeDoesNotExist(id);
        }

        return employee;
    }

    public Employee modifyEmployee(Long id, Map<String, Object> changes) {
        Employee employee = employeeRepository.findEmployeeById(id);
        Set<String> allowedFields = Set.of("name", "surname", "endDate", "departmentId");

        if (employee == null) throw new EmployeeDoesNotExist(id);

        BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(employee); // Spring automatic casting!!!!!

        changes.forEach((field, value) -> {
            if (allowedFields.contains(field.toLowerCase())) {
                wrapper.setPropertyValue(field, value); // The wrapper will cast the value with the field type.
            } else {
                throw new FieldChangeNotAllowed(field);
            }
        });

        return employeeRepository.save(employee);
    }
}
