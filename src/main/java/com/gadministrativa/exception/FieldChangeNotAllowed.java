package com.gadministrativa.exception;

public class FieldChangeNotAllowed extends RuntimeException {
    public FieldChangeNotAllowed(String field) {
        super("The field '" + field + "' can not be updated.");
    }
}
