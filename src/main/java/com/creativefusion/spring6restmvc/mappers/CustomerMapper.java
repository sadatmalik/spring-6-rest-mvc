package com.creativefusion.spring6restmvc.mappers;

import com.creativefusion.spring6restmvc.entities.Customer;
import com.creativefusion.spring6restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * @author sm@creativefusion.net
 */
@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);
    CustomerDTO customerToCustomerDto(Customer customer);
}
