package guru.springframework.mssc_brewery.services.v2;

import java.util.UUID;

import guru.springframework.mssc_brewery.web.model.v2.BeerDtoV2;

public interface BeerServiceV2 {
	BeerDtoV2 getBeerById(UUID beerId);

	BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

	void updateBeer(UUID beerId, BeerDtoV2 beerDto);
	
	void deleteById(UUID beerId);
}
