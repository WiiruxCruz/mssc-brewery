package guru.springframework.mssc_brewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.mssc_brewery.services.CustomerService;
import guru.springframework.mssc_brewery.web.model.CustomerDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
	
	@PostMapping //POST - create new customer
	public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
		CustomerDto savedDto = cs.saveNewCustomer(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		//todo add hostname to url
		headers.add("Location", "/api/v1/customer/" + savedDto.getId().toString());
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleUpdate(
			@PathVariable("customerId") UUID customerId,
			@RequestBody CustomerDto customerDto
	) {
		cs.updateCustomer(customerId, customerDto);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer( @PathVariable("customerId") UUID customerId) {
		cs.deleteById(customerId);
	}
}
