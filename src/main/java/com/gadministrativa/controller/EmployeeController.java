package com.gadministrativa.controller;

import com.gadministrativa.dto.EmployeeRequestDTO;
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
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.addEmployee(employeeRequestDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> checkEmployee(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
               .body(employeeService.getEmployee(id));
    }

    @PatchMapping("/modify")
    public ResponseEntity<?> modifyEmployee(@RequestParam Long id, @RequestBody Map<String, Object> changes) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeService.modifyEmployee(id, changes));
    }
}
