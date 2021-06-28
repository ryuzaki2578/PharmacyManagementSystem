package com.MedicineStock.Controller;

import com.MedicineStock.Exception.TokenValidationFailedException;
import com.MedicineStock.FeignClient.AuthenticationFeignClient;
import com.MedicineStock.Model.JwtResponse;
import com.MedicineStock.Model.MedicineStock;
import com.MedicineStock.Services.MedicineStockServices;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("")
public class MedicineStockController {
    @Autowired
    private AuthenticationFeignClient authFeignClient;
    @Autowired
    MedicineStockServices medicineStockServices;
    @GetMapping("/medicineStockInformation")
    public ResponseEntity<List<MedicineStock>> getMedicineStock(@RequestHeader(name="Authorization") String token){
        log.info("Start");
        log.debug("Jwt Response {}:",token);
        List<MedicineStock> medicineStockInformation=null;
        try{
            JwtResponse jwtResponse=authFeignClient.verifyToken(token);
            log.debug("Jwt Response {}:",jwtResponse);
            if(jwtResponse.isValid()){
                log.info("TOKEN IS VALID");
                medicineStockInformation=medicineStockServices.getMedicineStockInformation();
            }
        }
        catch (FeignException e){
            log.error("Token Validation Failed");
            throw new TokenValidationFailedException("Token Expired");
        }
        log.info("End");
        return new ResponseEntity<List<MedicineStock>>(medicineStockInformation,HttpStatus.OK);

    }
    @GetMapping("/byTreatingAilment/{treatingAilment}")
    public ResponseEntity<?> getMedicineByTreatingAilment(@RequestHeader(name = "Authorization") String token,
                                                          @PathVariable("treatingAilment") String treatingAilment) {
        log.info("START");
        log.debug("TOKEN {}:", token);
        log.debug("TREATING AILMENT {}:", treatingAilment);
        List<String> medicines = new ArrayList<>();
        try {
            JwtResponse jwtResponse = authFeignClient.verifyToken(token);
            log.debug("JWT RESPONSE {}:", jwtResponse);
            if (jwtResponse.isValid()) {
                log.info("TOKEN IS VALID");
                List<MedicineStock> medicineByTargetAilment = medicineStockServices
                        .getMedicineByTargetAilment(treatingAilment);
                log.debug("MEDICINE BY TARGET AILMENT {}: ", medicineByTargetAilment);
                for (@SuppressWarnings("rawtypes")
                     Iterator iterator = medicineByTargetAilment.iterator(); iterator.hasNext();) {
                    MedicineStock medicineStock = (MedicineStock) iterator.next();
                    medicines.add(medicineStock.getName());
                }
            }
        } catch (FeignException e) {
            log.error("TOKEN VALIDATION FAILED");
            throw new TokenValidationFailedException("TOKEN EXPIRED");
        }
        log.info("END");
        return new ResponseEntity<>(medicines.toArray(new String[0]), HttpStatus.OK);

    }
    @GetMapping("/get-stock-count/{medicine}")
    public ResponseEntity<?> getStockCountForMedicine(@RequestHeader(name = "Authorization") String token,
                                                      @PathVariable("medicine") String medicine) {
        log.info("START");

        MedicineStock medicineStock = null;
        try {
            JwtResponse jwtResponse = authFeignClient.verifyToken(token);
            if (jwtResponse.isValid()) {
                medicineStock = medicineStockServices.getNumberOfTabletsInStockByName(medicine);
            }
        } catch (FeignException e) {
            log.info("EXCEPTION: TOKEN EXPIRED");
            throw new TokenValidationFailedException("TOKEN EXPIRED");
        }
        log.info("END");
        return new ResponseEntity<>(medicineStock, HttpStatus.OK);
    }
    @PostMapping("/update-stock/{medicine}/{count}")
    public Boolean updateNumberOfTabletsInStockByName(@RequestHeader(name = "Authorization") String token,
                                                      @PathVariable("medicine") String medicine, @PathVariable("count") int count) {

        log.info("START");
        Boolean ans = false;

        try {
            JwtResponse jwtResponse = authFeignClient.verifyToken(token);
            if (jwtResponse.isValid()) {
                ans = medicineStockServices.updateNumberOfTabletsInStockByName(medicine, count);
            }
        } catch (FeignException e) {
            log.info("EXCEPTION : TOKEN EXPIRED");
            throw new TokenValidationFailedException("TOKEN EXPIRED");
        }
        log.info("END");
        return ans;

    }

}
