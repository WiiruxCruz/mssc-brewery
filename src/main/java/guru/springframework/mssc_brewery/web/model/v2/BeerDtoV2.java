package guru.springframework.mssc_brewery.web.model.v2;

import java.util.UUID;

import guru.springframework.mssc_brewery.web.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDtoV2 {
	private UUID id;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private Long upc;
}
