package com.creativefusion.spring6restmvc.services;

import com.creativefusion.spring6restmvc.model.Beer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
public interface BeerService {
    Beer saveNewBeer(Beer beer);
    List<Beer> listBeers();
    Optional<Beer> getBeerById(UUID id);
    void updateBeerById(UUID beerId, Beer beer);
    void patchBeerById(UUID beerId, Beer beer);
    void deleteById(UUID beerId);
}
