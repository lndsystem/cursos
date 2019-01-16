package com.hibcode.beerstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibcode.beerstore.model.Beer;
import com.hibcode.beerstore.repository.Beers;
import com.hibcode.beerstore.service.exception.BeerAlreadyExistException;

@Service
public class BeerService {

	private Beers beers;

	public BeerService(@Autowired Beers beers) {
		this.beers = beers;
	}

	public Beer save(final Beer beer) {
		verifyIfBeerExists(beer);
		return beers.save(beer);
	}

	private void verifyIfBeerExists(final Beer beer) {
		Optional<Beer> beerByNameAndType = beers.findByNameAndType(beer.getName(), beer.getType());

		if (beerByNameAndType.isPresent() && (beer.isNew() || isUpdatingToADifferentBeer(beer, beerByNameAndType))) {
			throw new BeerAlreadyExistException();
		}
	}

	private boolean isUpdatingToADifferentBeer(Beer beer, Optional<Beer> beerByNameAndType) {
		return beer.alreadyExist() && !beerByNameAndType.get().equals(beer);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
}
