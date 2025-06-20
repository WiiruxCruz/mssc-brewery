package guru.springframework.mssc_brewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.mssc_brewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		// TODO Auto-generated method stub
		return CustomerDto.builder().id(UUID.randomUUID())
				.name("Customer name")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.build()
				;
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		log.debug("Updating a customer...");
	}

	@Override
	public void deleteById(UUID customerId) {
		// TODO Auto-generated method stub
		log.debug("Deleting a customer...");
	}
	
}
