package com.MedicineStock.Services;

import com.MedicineStock.Model.MedicineStock;
import com.MedicineStock.Repository.MedicineStockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MedicineStockServices {
    @Autowired
    MedicineStockRepository medicineStockRepository;
    public List<MedicineStock> getMedicineStockInformation(){
        log.info("Start");
        List<MedicineStock> medicineStock= (medicineStockRepository.findAll());
        log.info("End");
            return medicineStock;
    }
    public List<MedicineStock> getMedicineByTargetAilment(String targetAilment){
        log.info(("Start"));
        log.info("End");
        return medicineStockRepository.getMedicineByTargetAilment(targetAilment);
    }
    public MedicineStock getNumberOfTabletsInStockByName(String medicineName){
        log.info("Start");
        log.info("End");
        MedicineStock numberOfTabletsInStockByName=medicineStockRepository.getNumberOfTabletsInStockByName(medicineName);
        log.debug("Number of Tablets in Stock By Name {}:",numberOfTabletsInStockByName);
        return numberOfTabletsInStockByName;
    }
    public boolean updateNumberOfTabletsInStockByName(String medicineName,int count){
        log.info("Start");
        log.debug(medicineName+"\t"+count);
        medicineStockRepository.updateNumberOfTabletsInStockByName(medicineName,count);
        log.info("End");
        return true;
    }
}
