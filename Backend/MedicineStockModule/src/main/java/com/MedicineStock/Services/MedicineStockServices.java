package com.MedicineStock.Services;

import com.MedicineStock.Exception.RequestResourceNotFountException;
import com.MedicineStock.Model.MedicineStock;
import com.MedicineStock.Repository.MedicineStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineStockServices {
    @Autowired
    MedicineStockRepository medicineStockRepository;
    public List<MedicineStock> getMedicineStock(){
        List<MedicineStock> medicineStock= (medicineStockRepository.findAll());
            return medicineStock;
    }
}
