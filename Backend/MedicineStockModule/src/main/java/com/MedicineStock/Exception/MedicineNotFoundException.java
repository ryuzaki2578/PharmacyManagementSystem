package com.MedicineStock.Exception;


public class MedicineNotFoundException extends RuntimeException {

    private static final long serialVersionUID=1;
    public MedicineNotFoundException(String message) {
        super(message);

    }


}

