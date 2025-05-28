package guru.springframework.mssc_brewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.mssc_brewery.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		// TODO Auto-generated method stub
		return CustomerDto.builder().id(UUID.randomUUID())
				.name("Customer name")
				.build();
	}

}
