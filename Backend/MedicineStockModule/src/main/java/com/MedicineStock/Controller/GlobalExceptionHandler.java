package com.MedicineStock.Controller;
import java.util.Date;

import com.MedicineStock.Exception.RequestResourceNotFountException;
import com.MedicineStock.Model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(RequestResourceNotFountException.class)
    public ResponseEntity<ErrorModel> requestResourceNotFoundException(RequestResourceNotFountException ex, WebRequest req)
    {


        ErrorModel error = new ErrorModel(new Date(), HttpStatus.NOT_FOUND.value(), "NOT FOUND",ex.getMessage(), req.getDescription(false));


        return new ResponseEntity<ErrorModel>(error, HttpStatus.NOT_FOUND);

    }


}


