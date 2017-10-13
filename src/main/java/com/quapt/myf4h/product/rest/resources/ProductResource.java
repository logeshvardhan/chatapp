/**
 * 
 */
package com.quapt.myf4h.product.rest.resources;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quapt.myf4h.product.rest.dto.UserDTO;

/**
 * @author user20
 *
 */
@RestController
@RequestMapping("/api/resource")
public class ProductResource {
	
	@RequestMapping(value = "/home",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO welcome() {
		String result1 = "Welcome to Home page";
		
		UserDTO result = new UserDTO();
		result.setName("Anand");
		
		return result;
	}

}
