package com.cognizant.pharmacysupply.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.pharmacysupply.model.JwtResponse;

/*
 * This Feign Client is used to connect to authorization-service present at port 8084.
 */

@FeignClient(name = "authorization-service", url = "http://localhost:8084")
public interface AuthenticationFeignClient {

	/*
	 * Method Name --> verifyToken
	 * @param      --> Token  (given as an input to check if the session is valid or not)
	 */
	@GetMapping(value = "/api/auth/validate" )
	public JwtResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);
	
}
