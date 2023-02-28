package com.creativefusion.spring6restmvc.services;

import com.creativefusion.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
public interface BeerService {
    Beer saveNewBeer(Beer beer);
    List<Beer> listBeers();
    Beer getBeerById(UUID id);
}
