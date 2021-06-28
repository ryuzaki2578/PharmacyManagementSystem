package com.MedicineStock.FeignClient;

import com.MedicineStock.Model.JwtResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "authorization-service", url ="http://localhost:8084")
public interface AuthenticationFeignClient {


    @GetMapping(path = "/api/auth/validate")
    public JwtResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
