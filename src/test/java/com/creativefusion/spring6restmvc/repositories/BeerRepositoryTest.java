package com.creativefusion.spring6restmvc.repositories;

import com.creativefusion.spring6restmvc.bootstrap.BootstrapData;
import com.creativefusion.spring6restmvc.entities.Beer;
import com.creativefusion.spring6restmvc.model.BeerStyle;
import com.creativefusion.spring6restmvc.services.BeerCsvServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
class BeerRepositoryTest {

    private static final String LONG_NAME = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Autowired BeerRepository beerRepository;

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                                                 .beerName("My Beer")
                                                 .beerStyle(BeerStyle.PALE_ALE)
                                                 .upc("234234234234")
                                                 .price(new BigDecimal("11.99"))
                                                 .build());
        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertEquals("My Beer", savedBeer.getBeerName());
        assertThat(savedBeer.getId()).isNotNull();
    }


    @Test
    void testSaveBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName(LONG_NAME)
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("234234234234")
                    .price(new BigDecimal("11.99"))
                    .build());

            beerRepository.flush();
        });
    }

    @Test
    void testGetBeerListByName() {
        Page<Beer> page = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        assertThat(page.getContent().size()).isEqualTo(336);
    }
}
