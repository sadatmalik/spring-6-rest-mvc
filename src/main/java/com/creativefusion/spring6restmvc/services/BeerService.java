package com.creativefusion.spring6restmvc.services;

import com.creativefusion.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
public interface BeerService {
    List<Beer> listBeers();
    Beer getBeerById(UUID id);
}
