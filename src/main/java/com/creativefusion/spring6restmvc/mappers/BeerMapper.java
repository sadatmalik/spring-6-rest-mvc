package com.creativefusion.spring6restmvc.mappers;

import com.creativefusion.spring6restmvc.entities.Beer;
import com.creativefusion.spring6restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * @author sm@creativefusion.net
 */
@Mapper
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);
    BeerDTO beerToBeerDto(Beer beer);
}
