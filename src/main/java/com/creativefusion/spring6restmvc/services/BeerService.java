package com.creativefusion.spring6restmvc.services;

import com.creativefusion.spring6restmvc.model.BeerDTO;
import com.creativefusion.spring6restmvc.model.BeerStyle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
public interface BeerService {
    BeerDTO saveNewBeer(BeerDTO beer);
    List<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber,
                            Integer pageSize);
    Optional<BeerDTO> getBeerById(UUID id);
    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);
    Optional<BeerDTO> patchBeerById(UUID beerId, BeerDTO beer);
    Boolean deleteById(UUID beerId);
}
