package guru.springframework.mssc_brewery.web.controller.v2;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.mssc_brewery.services.v2.BeerServiceV2;
import guru.springframework.mssc_brewery.web.model.v2.BeerDtoV2;


@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
	
	private final BeerServiceV2 beerServiceV2;
	
	public BeerControllerV2(BeerServiceV2 bs) {
		this.beerServiceV2 = bs;
	}
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){
		
		return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping //POST - create new beer
	public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDto) {
		BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		//todo add hostname to url
		headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {
		
		beerServiceV2.updateBeer(beerId, beerDto);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		beerServiceV2.deleteById(beerId);
	}
}
