package com.creativefusion.spring6restmvc.services;

import com.creativefusion.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

/**
 * @author sm@creativefusion.net
 */
public interface CustomerService {
    Customer saveNewCustomer(Customer customer);
    Customer getCustomerById(UUID uuid);
    List<Customer> getAllCustomers();
}
