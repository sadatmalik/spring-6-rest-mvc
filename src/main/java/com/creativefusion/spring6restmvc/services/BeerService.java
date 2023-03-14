package com.creativefusion.spring6restmvc.services;

import com.creativefusion.spring6restmvc.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
public interface BeerService {
    BeerDTO saveNewBeer(BeerDTO beer);
    List<BeerDTO> listBeers();
    Optional<BeerDTO> getBeerById(UUID id);
    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);
    void patchBeerById(UUID beerId, BeerDTO beer);
    void deleteById(UUID beerId);
}
