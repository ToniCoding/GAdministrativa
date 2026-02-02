package com.gadministrativa.exception;

public class EmployeeDoesNotExist extends RuntimeException {
    public EmployeeDoesNotExist(Long id) {
        super("Employee with '" + id + "' does not exist.");
    }
}
