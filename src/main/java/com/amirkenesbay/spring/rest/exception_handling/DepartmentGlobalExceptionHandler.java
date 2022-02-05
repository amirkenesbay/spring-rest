package com.amirkenesbay.spring.rest.exception_handling;

import com.amirkenesbay.spring.rest.entity.Department;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<DepartmentIncorrectData> handleException(NoSuchDepartmentException exception){
        DepartmentIncorrectData data = new DepartmentIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<DepartmentIncorrectData> handleException(Exception exception){
        DepartmentIncorrectData data = new DepartmentIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
