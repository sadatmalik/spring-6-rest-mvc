package com.creativefusion.spring6restmvc.services;

import com.creativefusion.spring6restmvc.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
public interface CustomerService {
    Customer saveNewCustomer(Customer customer);
    Optional<Customer> getCustomerById(UUID uuid);
    List<Customer> getAllCustomers();
    void updateCustomerById(UUID customerId, Customer customer);
    void patchCustomerById(UUID customerId, Customer customer);
    void deleteCustomerById(UUID customerId);
}
