package com.creativefusion.spring6restmvc.services;

import com.creativefusion.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
public interface CustomerService {
    CustomerDTO saveNewCustomer(CustomerDTO customer);
    Optional<CustomerDTO> getCustomerById(UUID uuid);
    List<CustomerDTO> getAllCustomers();
    Optional<CustomerDTO> updateCustomerById(UUID customerId, CustomerDTO customer);
    Optional<CustomerDTO> patchCustomerById(UUID customerId, CustomerDTO customer);
    Boolean deleteCustomerById(UUID customerId);
}
