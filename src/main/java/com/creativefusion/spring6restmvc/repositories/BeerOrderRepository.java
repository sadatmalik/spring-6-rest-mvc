package com.creativefusion.spring6restmvc.repositories;

import com.creativefusion.spring6restmvc.entities.BeerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
public interface BeerOrderRepository extends JpaRepository<BeerOrder, UUID> {
}
