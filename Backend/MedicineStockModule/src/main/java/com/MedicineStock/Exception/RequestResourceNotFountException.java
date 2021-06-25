package com.MedicineStock.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequestResourceNotFountException extends RuntimeException {

    public RequestResourceNotFountException(String message) {
        super(message);

    }


}

