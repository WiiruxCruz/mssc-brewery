package guru.springframework.mssc_brewery.services;

import java.util.UUID;

import guru.springframework.mssc_brewery.web.model.BeerDto;

public interface BeerService {
	BeerDto getBeerById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);
}
