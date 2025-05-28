package guru.springframework.mssc_brewery.services;

import java.util.UUID;

import guru.springframework.mssc_brewery.web.model.CustomerDto;

public interface CustomerService {
	CustomerDto getCustomerById(UUID customerId);
}
