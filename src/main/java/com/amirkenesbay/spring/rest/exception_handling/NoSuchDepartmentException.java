package com.amirkenesbay.spring.rest.exception_handling;

public class NoSuchDepartmentException extends RuntimeException{
    public NoSuchDepartmentException(String message) {
        super(message);
    }
}
