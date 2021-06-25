package com.MedicineStock.Controller;

import com.MedicineStock.Model.MedicineStock;
import com.MedicineStock.Services.MedicineStockServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class MedicineStockController {
    @Autowired
    MedicineStockServices medicineStockServices;
    @RequestMapping("/MedicineStockInformation")
    public ResponseEntity<List<MedicineStock>> getMedicineStock(@RequestParam String name){
        return new ResponseEntity<List<MedicineStock>>(medicineStockServices.getMedicineStock(), HttpStatus.OK);

    }
}
