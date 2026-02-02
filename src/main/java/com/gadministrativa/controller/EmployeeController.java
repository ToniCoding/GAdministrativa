package com.gadministrativa.controller;

import com.gadministrativa.dto.EmployeeRequestDTO;
import com.gadministrativa.entity.Employee;
import com.gadministrativa.exception.EmployeeDoesNotExist;
import com.gadministrativa.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        try {
            Employee newEmployee = employeeService.addEmployee(employeeRequestDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error interno"));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> checkEmployee(@PathVariable Long id) {
        try {
            Employee foundEmployee = employeeService.getEmployee(id);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(foundEmployee);
        } catch (EmployeeDoesNotExist e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "El empleado no existe"));
        }
    }

}
