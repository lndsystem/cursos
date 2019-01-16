package com.hibcode.beerstore.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hibcode.beerstore.model.Beer;
import com.hibcode.beerstore.model.BeerType;
import com.hibcode.beerstore.repository.Beers;
import com.hibcode.beerstore.service.exception.BeerAlreadyExistException;

public class BeerServiceTest {

	private BeerService beerService;

	@Mock
	private Beers beersMocked;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		beerService = new BeerService(beersMocked);
	}

	@Test(expected = BeerAlreadyExistException.class)
	public void should_deny_creation_of_beer_that_exists() {
		Beer beerInDatabase = new Beer();
		beerInDatabase.setId(10l);
		beerInDatabase.setName("Skol");
		beerInDatabase.setType(BeerType.LAGER);
		beerInDatabase.setVolume(new BigDecimal(600.0));
		when(beersMocked.findByNameAndType("Skol", BeerType.LAGER)).thenReturn(Optional.of(beerInDatabase));

		Beer beer = new Beer();
		beer.setName("Skol");
		beer.setType(BeerType.LAGER);
		beer.setVolume(new BigDecimal(300.0));

		beerService.save(beer);

	}

	@Test
	public void should_create_new_beer() {

		Beer beer = new Beer();
		beer.setName("Skol");
		beer.setType(BeerType.LAGER);
		beer.setVolume(new BigDecimal(300.0));

		Beer newBeerDatabase = new Beer();
		newBeerDatabase.setId(10l);
		newBeerDatabase.setName("Skol");
		newBeerDatabase.setType(BeerType.LAGER);
		newBeerDatabase.setVolume(new BigDecimal(300.0));

		when(beersMocked.save(beer)).thenReturn(newBeerDatabase);
		Beer beerSaved = beerService.save(beer);

		assertThat(beerSaved.getId(), equalTo(10l));
		assertThat(beerSaved.getName(), equalTo("Skol"));
		assertThat(beerSaved.getType(), equalTo(BeerType.LAGER));

	}

	@Test
	public void should_update_beer_volume() {
		final Beer beerInDatabase = new Beer();
		beerInDatabase.setId(10L);
        beerInDatabase.setName("Devassa");
        beerInDatabase.setType(BeerType.PILSEN);
        beerInDatabase.setVolume(new BigDecimal("300"));

		when(beersMocked.findByNameAndType("Devassa", BeerType.PILSEN)).thenReturn(Optional.of(beerInDatabase));
		
		final Beer beerToUpdate = new Beer();
        beerToUpdate.setId(10L);
        beerToUpdate.setName("Devassa");
        beerToUpdate.setType(BeerType.PILSEN);
        beerToUpdate.setVolume(new BigDecimal("200"));

        final Beer beerMocked = new Beer();
        beerMocked.setId(10L);
        beerMocked.setName("Devassa");
        beerMocked.setType(BeerType.PILSEN);
        beerMocked.setVolume(new BigDecimal("200"));

        when(beersMocked.save(beerToUpdate)).thenReturn(beerMocked);

	}
	
	@Test(expected = BeerAlreadyExistException.class)
    public void should_deny_update_of_an_existing_beer_that_already_exists() {
        final Beer beerInDatabase = new Beer();
        beerInDatabase.setId(10L);
        beerInDatabase.setName("Heineken");
        beerInDatabase.setType(BeerType.LAGER);
        beerInDatabase.setVolume(new BigDecimal("355"));

        when(beersMocked.findByNameAndType("Heineken", BeerType
                .LAGER)).thenReturn(Optional.of(beerInDatabase));

        final Beer beerToUpdate = new Beer();
        beerToUpdate.setId(5L);
        beerToUpdate.setName("Heineken");
        beerToUpdate.setType(BeerType.LAGER);
        beerToUpdate.setVolume(new BigDecimal("355"));

        beerService.save(beerToUpdate);
    }

}
