package com.gadministrativa.exception;

public class EmployeeDoesNotExist extends RuntimeException {
    public EmployeeDoesNotExist(Long id) {
        super("Employee with ID '" + id + "' does not exist.");
    }
}
