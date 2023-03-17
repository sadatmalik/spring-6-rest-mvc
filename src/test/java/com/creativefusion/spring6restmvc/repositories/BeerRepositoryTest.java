package com.creativefusion.spring6restmvc.repositories;

import com.creativefusion.spring6restmvc.entities.Beer;
import com.creativefusion.spring6restmvc.model.BeerStyle;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
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
}
