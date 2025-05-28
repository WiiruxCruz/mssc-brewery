package guru.springframework.mssc_brewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.mssc_brewery.services.CustomerService;
import guru.springframework.mssc_brewery.web.model.CustomerDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	private final CustomerService cs;
	
	public CustomerController(CustomerService cs) {
		this.cs = cs;
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
		
		return new ResponseEntity<>(cs.getCustomerById(customerId), HttpStatus.OK);
	}
	
}
